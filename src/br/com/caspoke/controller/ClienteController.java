package br.com.caspoke.controller;

import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.model.Cliente;
import br.com.caspoke.model.PersistentLogin;
import br.com.caspoke.springmvc.service.ClienteProfileService;
import br.com.caspoke.springmvc.service.ClienteService;
import br.com.caspoke.springmvc.service.PersistentLoginService;

@Controller
@Transactional
public class ClienteController {

	@Autowired
    ClienteService clienteService;
	
	@Autowired
    ClienteProfileService clienteProfileService;
	
	@Autowired
	PersistentLoginService persistentLoginService;
	
	@Autowired
    MessageSource messageSource;
	
	@Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	@Qualifier("jpaClienteDao")
	private IClienteDao dao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		if (isCurrentAuthenticationAnonymous()) {
			model.addAttribute("cliente", new Cliente());
            return "formulario-login";
        } else {
            return "redirect:menu";  
        }
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Cliente c, Model model) {
		System.out.println("usuario: " + c.getSsoId());
		System.out.println("senha: " + c.getSenha());
		Cliente cliente = dao.buscaPorSSO(c.getSsoId());
		
		if (cliente != null) {
			return "redirect:menu";
		}
		else {
			System.out.println("Cliente não encontrado");
		}
		return "redirect:login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            //new SecurityContextLogoutHandler().logout(request, response, auth);
        	if (persistentLoginService.existeSSO(auth.getName()))
        	{
        		persistentTokenBasedRememberMeServices.logout(request, response, auth);
        	}
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:menu?logout";
	}
	
	@RequestMapping("novoCliente")
	public String form (Cliente cliente, Model model) {
		model.addAttribute("cliente", cliente);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("roles", clienteProfileService.lista());
		return "cliente/formulario";
	}
	
	//Tratar validação
	@RequestMapping("adicionaCliente")
	public String adiciona(@Valid Cliente c, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			System.out.println("TEM ERROS");
			model.addAttribute("roles", clienteProfileService.lista());
            return "cliente/formulario";
        }
		
		if(!clienteService.isUserSSOUnique((int)c.getId(), c.getSsoId())) {
            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{c.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            model.addAttribute("roles", clienteProfileService.lista());
            return "cliente/formulario";
        }
		
		//OPERAÇÃO APENAS PRA ADMIN: GERAÇÃO AUTOMATICA DE EMAIL QUANDO NULO (dúvida: mensagem de erro @notnull ou criar email novo?)
		if (c.getEmail().equals(""))
		{
			String[] nomes = c.getNome().toLowerCase().split(" ");
			String email = "";
			for (int i = 0; i < nomes.length; i++)
			{
				email = email + nomes[i];
			}
			email += "@caspokewigs.com";
			c.setEmail(email);
		}
		
		//Esses campos só estão disponíveis para edição no modo admin
		if (c.getData() == null)
			c.setData(Calendar.getInstance());
		
		//tratar permissao
		
		
		clienteService.insere(c);
		
		model.addAttribute("success", "Usuário " + c.getNome() + " registrado com sucesso!");
        model.addAttribute("loggedinuser", getPrincipal());
        
        
        
		return "redirect:efetuaLogin";
		//so faz sentido ir pra lista de clientes se quem tiver feito o login tiver sido o admin
		//return "redirect:listaClientes";
	}
	
	@RequestMapping("listaClientes")
	public String lista(Model model) {
		model.addAttribute("clientes", dao.lista());
		return "cliente/lista";
	}
	
	@RequestMapping("removeCliente")
	public String remove(Cliente c) {
		dao.remove(c);
		return "redirect:listaClientes";
	}
	
	@RequestMapping("mostraCliente")
	public String mostra(long id, Model model) {
		model.addAttribute("c", dao.buscaPorId(id));
		return "cliente/mostra";
	}
	
	@RequestMapping("alteraCliente")
	public String altera(Cliente c) {
		//OPERAÇÃO APENAS PRA ADMIN: GERAÇÃO AUTOMATICA DE EMAIL
				if (c.getEmail().equals(""))
				{
					String[] nomes = c.getNome().toLowerCase().split(" ");
					String email = "";
					for (int i = 0; i < nomes.length; i++)
					{
						email = email + nomes[i];
					}
					email += "@caspokewigs.com";
					c.setEmail(email);
				}
		dao.altera(c);
		return "redirect:listaClientes";
	}
	
	
	
	
	
	
	//retorna Principal (nome de usuário) do cliente logado
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
		    userName = principal.toString();
		}
		return userName;
	}
	
	private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}

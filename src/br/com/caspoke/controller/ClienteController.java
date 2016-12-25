package br.com.caspoke.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.model.Cliente;
import br.com.caspoke.model.Permissao;

@Controller
@Transactional
public class ClienteController {

	@Autowired
	@Qualifier("jpaClienteDao")
	private IClienteDao dao;
	
	@RequestMapping("novoCliente")
	public String form (Cliente c, Model model) {
		model.addAttribute("c", c);
		return "cliente/formulario";
	}
	
	//Atuais problemas:
	//- Não deve ser permitido criar email automatico se não for admin
	@RequestMapping("adicionaCliente")
	public String adiciona(@ModelAttribute("cliente") Cliente c) {
		
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
		
		//Esses campos só estão disponíveis para edição no modo admin
		if (c.getData() == null)
			c.setData(Calendar.getInstance());
		if (c.getPermissao() == null)
			c.setPermissao(Permissao.NORMAL.name());
		
		dao.insere(c);
		
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
	
}

package br.com.caspoke.controller;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.model.Cliente;
import br.com.caspoke.springmvc.service.ClienteProfileService;
import br.com.caspoke.springmvc.service.ClienteService;

@Controller
@Transactional
public class LoginController {

		@RequestMapping(value = {"/", "menu"}, method = RequestMethod.GET)
		public String menu(Model model) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "menu";
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
}

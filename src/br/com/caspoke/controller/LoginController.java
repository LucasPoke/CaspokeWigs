package br.com.caspoke.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.model.Cliente;

@Controller
@Transactional
public class LoginController {

		@Autowired
		@Qualifier("jpaClienteDao")
		private IClienteDao dao;
		
		@RequestMapping("loginForm")
		public String loginForm() {
			return "formulario-login";
		}
		
		@RequestMapping("efetuaLogin")
		public String efetuaLogin(Cliente c, HttpSession session) {
			Cliente cliente = dao.buscaPorLogin(c);
			
			if (cliente != null) {
				session.setAttribute("usuarioLogado", cliente);
				return "menu";
			}
			return "redirect:loginForm";
		}
		
		@RequestMapping("logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:loginForm";
		}
		
		@RequestMapping("menu")
		public String menu() {
			return "menu";
		}
}

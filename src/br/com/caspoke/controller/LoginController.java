package br.com.caspoke.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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
		public String loginForm(Model model) {
			model.addAttribute("c", new Cliente());
			return "formulario-login";
		}
		
		@RequestMapping("efetuaLogin")
		public String efetuaLogin(Cliente c, HttpSession session) {
			System.out.println("email: " + c.getEmail());
			System.out.println("senha: " + c.getSenha());
			Cliente cliente = dao.buscaPorEmail(c);
			
			if (cliente != null) {
				session.setAttribute("usuarioLogado", cliente);
				return "menu";
			}
			else {
				System.out.println("Cliente não encontrado");
			}
			return "redirect:loginForm";
		}
		
		@RequestMapping("logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "menu";
		}
		
		@RequestMapping("menu")
		public String menu() {
			return "menu";
		}
}

package br.com.caspoke.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.model.Cliente;

@Controller
@Transactional
public class ClienteController {

	@Autowired
	@Qualifier("jpaClienteDao")
	private IClienteDao dao;
	
	@RequestMapping("novoCliente")
	public String form () {
		return "cliente/formulario";
	}
	
	//Atuais problemas:
	//- Problema ao criar login automático para uma pessoa com nome repetido (UNIQUE login)
	//- Não deve ser permitido criar login automatico se não for admin
	@RequestMapping("adicionaCliente")
	public String adiciona(@Valid Cliente c, BindingResult result) {
		
		if(result.hasFieldErrors("nome")) {
		    return "cliente/formulario";
		  }    
		if(result.hasFieldErrors("login")) {
		    return "cliente/formulario";
		  }   
		if(result.hasFieldErrors("senha")) {
		    return "cliente/formulario";
		  }
		
		//OPERAÇÃO APENAS PRA ADMIN: GERAÇÃO AUTOMATICA DE LOGIN
		if (c.getLogin().equals(""))
		{
			String[] nomes = c.getNome().toLowerCase().split(" ");
			String login = "";
			for (int i = 0; i < nomes.length; i++)
			{
				login = login + nomes[i];
			}
			c.setLogin(login);
		}
		
		if (c.getData() == null)
			c.setData(Calendar.getInstance());
		
		dao.insere(c);
		return "redirect:listaClientes";
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
		model.addAttribute("cliente", dao.buscaPorId(id));
		return "cliente/mostra";
	}
	
	@RequestMapping("alteraCliente")
	public String altera(Cliente c) {
		//OPERAÇÃO APENAS PRA ADMIN: GERAÇÃO AUTOMATICA DE LOGIN
		if (c.getLogin().equals(""))
		{
			System.out.println("Id: " + c.getId());
			String[] nomes = c.getNome().toLowerCase().split(" ");
			String login = "";
			for (int i = 0; i < nomes.length; i++)
			{
				login = login + nomes[i];
			}
			c.setLogin(login);
		}
		dao.altera(c);
		return "redirect:listaClientes";
	}
	
}

package br.com.caspoke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.jdbc.EstoqueDao;

@Controller
public class EstoqueController {

	private final EstoqueDao dao;
	
	@Autowired
	public EstoqueController(EstoqueDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("novoEstoque")
	public String form(long id, Model model)
	{
		model.addAttribute("peruca_id", id);
		return "estoque/formulario";
	}
}

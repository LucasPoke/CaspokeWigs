package br.com.caspoke.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.jdbc.PerucaDao;
import br.com.caspoke.model.Peruca;

@Controller
public class PerucaController {

	private final PerucaDao dao;
	
	@Autowired
	public PerucaController (PerucaDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("novaPeruca")
	public String form () {
		return "peruca/formulario";
	}
	
	@RequestMapping("adicionaPeruca")
	public String adiciona(@Valid Peruca p, BindingResult result) {
		ArrayList<String> cores = new ArrayList<String>(Arrays.asList(p.getCor().split("\\s*;\\s*")));
		if (cores.size() > 1)
		{
			System.out.println("adicionando mais de uma");
			dao.insereVariasCores(p, cores);
		}
		else
			dao.insere(p);
		return "redirect:listaPerucas";
	}
	
	@RequestMapping("listaPerucas")
	public String lista(Model model) {
		model.addAttribute("perucas", dao.getLista());
		return "peruca/lista";
	}
	
	
	@RequestMapping("removePeruca")
	public String remove(Peruca p) {
		dao.deleta(p);
		return "redirect:listaPerucas";
	}
	
	@RequestMapping("mostraPeruca")
	public String mostra(long id, Model model) {
		model.addAttribute("peruca", dao.busca(id));
		return "peruca/mostra";
	}
	
	@RequestMapping("alteraPeruca")
	public String altera(Peruca p) {
		dao.atualiza(p);
		return "redirect:listaPerucas";
	}
}

package br.com.caspoke.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.IEncomendaDao;
import br.com.caspoke.dao.IOrcamentoDao;
import br.com.caspoke.model.Encomenda;
import br.com.caspoke.model.Orcamento;
import br.com.caspoke.model.StatusEncomenda;

@Controller
@Transactional
public class EncomendaController {

	@Autowired
	@Qualifier("jpaEncomendaDao")
	private IEncomendaDao dao;
	
	@Autowired
	@Qualifier("jpaOrcamentoDao")
	private IOrcamentoDao orcamentoDao;
	
	@RequestMapping("novaEncomenda")
	public String form(long id, Model model) {
		System.out.println("Id: " + id);
		model.addAttribute("status", StatusEncomenda.values());
		model.addAttribute("id", id);
		return "encomenda/formulario";
	}
	
	@RequestMapping("listaEncomendas")
	public String lista(Model model) {
		model.addAttribute("encomendas", dao.lista());
		return "encomenda/lista";
	}
	
	@RequestMapping("adicionaEncomenda")
	public String adiciona(Encomenda e, long orcamento_id) {
		if (e.getData_pagamento() == null)
			e.setData_pagamento(Calendar.getInstance());
		//tratar data de iniciio
		
		Orcamento o = orcamentoDao.buscaPorId(orcamento_id);
		e.setOrcamento(o);
		System.out.println(e.getStatus());
		dao.insere(e);
		
		o.setAceito(true);
		orcamentoDao.altera(o);
		
		return "redirect:listaEncomendas";
	}
	
	@RequestMapping("removeEncomenda")
	public String remove(Encomenda e) {
		dao.remove(e);
		return "redirect:listaEncomendas";
	}
}

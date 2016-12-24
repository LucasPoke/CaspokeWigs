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
	
	@RequestMapping("alteraEncomenda")
	public String altera(Encomenda e, long orcamento_id) {
		Orcamento o = orcamentoDao.buscaPorId(orcamento_id);
		e.setOrcamento(o);
		printEncomenda(e);
		dao.altera(e);
		return "redirect:listaEncomendas";
	}
	
	@RequestMapping("mostraEncomenda")
	public String mostra(long id, Model model) {
		Encomenda e = dao.buscaPorId(id);
		model.addAttribute("encomenda", e);
		model.addAttribute("status", StatusEncomenda.values());
		return "encomenda/mostra";
	}
	
	public void printEncomenda (Encomenda e)
	{
		System.out.println("Dados da encomenda:");
		System.out.println("Preço: " + e.getPreco());
		System.out.println("Frete: " + e.getFrete());
		System.out.println("Status: " + e.getStatus());
		System.out.println("\nDados do orçamento:");
		System.out.println("Personagem: " + e.getOrcamento().getPersonagem());
		System.out.println("\nDados do cliente:");
		System.out.println("Cliente: " + e.getOrcamento().getCliente().getNome());
	}
}

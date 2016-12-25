package br.com.caspoke.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.IEncomendaDao;
import br.com.caspoke.dao.IOrcamentoDao;
import br.com.caspoke.dao.IPerucaBaseDao;
import br.com.caspoke.model.Encomenda;
import br.com.caspoke.model.Orcamento;
import br.com.caspoke.model.PerucaBase;
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
	
	@Autowired
	@Qualifier("jpaPerucaBaseDao")
	private IPerucaBaseDao perucaBaseDao;
	
	@RequestMapping("novaEncomenda")
	public String form(long id, Model model) {
		System.out.println("Id: " + id);
		model.addAttribute("status", StatusEncomenda.values());
		model.addAttribute("perucasBase", perucaBaseDao.listaNaoAssociadas());
		model.addAttribute("orcamento_id", id);
		return "encomenda/formulario";
	}
	/*
	@RequestMapping("listaEncomendas")
	public String lista(Model model) {
		model.addAttribute("encomendas", dao.lista());
		return "encomenda/lista";
	}*/
	
	@RequestMapping("listaEncomendas")
	public String lista(Model model) {
		model.addAttribute("encomendasEmAndamento", dao.listaEmAndamento());
		model.addAttribute("encomendasConcluidas", dao.listaConcluidas());
		model.addAttribute("encomendasEnviadas", dao.listaEnviadas());
		return "encomenda/lista";
	}
	
	@RequestMapping("adicionaEncomenda")
	public String adiciona(Encomenda e, long orcamento_id, ArrayList<String> idPerucas) {
		
		//TRATAR RASTREIO != NULL (ATUALMENTE, NAO ESTÁ NO FORMULARIO)
		//TRATAR CASO DE CHECKBOX "JÁ TENHO PERUCAS BASE
		System.out.println(idPerucas.get(0));
		/*
		//INSERÇÃO DE TODAS AS PERUCAS BASE E TRATAMENTO DE STATUS
		ArrayList<String> idsEmString = new ArrayList<String>(Arrays.asList(idPerucas.split("\\s*,\\s*")));
		//caso 1: nenhuma peruca base adicionada
		if (idsEmString.size() == 0)
		{
			e.setStatus(StatusEncomenda.AGUARDANDO_COMPRA);
		}
		//caso 2: perucas cadastradas
		else
		{
			boolean todasEmMaos = true;
			ArrayList<PerucaBase> perucas = new ArrayList();
			for (int i = 0; i < idsEmString.size(); i++)
			{
				perucas.add(perucaBaseDao.buscaPorId(Long.parseLong(idsEmString.get(i))));
				if (!perucas.get(i).isChegou())
				{
					todasEmMaos = false;
				}
			}
			e.setPerucasBase(perucas);
			//caso 2.1: todas as perucas em mãos
			if (todasEmMaos)
				e.setStatus(StatusEncomenda.EM_DESENVOLVIMENTO);
			//caso 2.2: aguardando perucas
			else
				e.setStatus(StatusEncomenda.AGUARDANDO_MATERIAIS);
		}
		
		
		//TRATAMENTO DA DATA DE PAGAMENTO
		if (e.getData_pagamento() == null)
			e.setData_pagamento(Calendar.getInstance());
		
		Orcamento o = orcamentoDao.buscaPorId(orcamento_id);
		e.setOrcamento(o);
		
		dao.insere(e);
		
		//ATUALIZAÇÃO DO STATUS DO ORCAMENTO
		o.setAceito(true);
		orcamentoDao.altera(o);
		*/
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
		System.out.println(e.getData_final().getTimeInMillis());
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
	
	@RequestMapping("concluir")
	public void concluir(long id) {
		
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

package br.com.caspoke.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.IPerucaBaseDao;
import br.com.caspoke.dao.IPerucaDao;
import br.com.caspoke.model.Peruca;
import br.com.caspoke.model.PerucaBase;

@Controller
@Transactional
public class PerucaBaseController {

	@Autowired
	@Qualifier("jpaPerucaDao")
	private IPerucaDao perucaDao;
	@Autowired
	@Qualifier("jpaPerucaBaseDao")
	private IPerucaBaseDao dao;
	
	@RequestMapping("novaPerucaBase")
	public String form(long id, Model model) {
		model.addAttribute("peruca_id", id);
		return "peruca-base/formulario";
	}
	
	@RequestMapping("adicionaPerucaBase")
	public String adiciona(long peruca_id, @Valid PerucaBase perucaBase, BindingResult result) {
		System.out.println("Id da peruca usada: " + peruca_id);
		perucaBase.setPeruca(perucaDao.buscaPorId(peruca_id));
		dao.insere(perucaBase);
		return "redirect:listaPerucasBase";
	}
	
	@RequestMapping("listaPerucasBase")
	public String lista(Model model) {
		model.addAttribute("perucas", dao.lista());
		return "peruca-base/lista";
	}
	
	@RequestMapping("mostraPerucaBase")
	public String mostra(long id, Model model) {
		PerucaBase p = dao.buscaPorId(id);
		model.addAttribute("perucaBase", p);
		return "peruca-base/mostra";
	}
	
	@RequestMapping("alteraPerucaBase")
	public String altera (long peruca_id, @Valid PerucaBase perucaBase, BindingResult result) {
		perucaBase.setPeruca(perucaDao.buscaPorId(peruca_id));
		dao.altera(perucaBase);
		return "redirect:listaPerucasBase";
	}
	
	//ESSE METODO DEVE, NO FUTURO, MUDAR AUTOMATICAMENTE O STATUS DA ENCOMENDA ASSOCIADA PARA "EM DESENVOLVIMENTO"
	@RequestMapping("atualizaChegada")
	public void atualizaChegada(long id) {
		PerucaBase p = dao.buscaPorId(id);
		p.setChegou(true);
		dao.altera(p);
	}
}

package br.com.caspoke.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.IEncomendaDao;
import br.com.caspoke.dao.IPerucaBaseDao;
import br.com.caspoke.dao.IPerucaDao;
import br.com.caspoke.model.Encomenda;
import br.com.caspoke.model.PerucaBase;
import br.com.caspoke.model.StatusEncomenda;

@Controller
@Transactional
public class PerucaBaseController {

	@Autowired
	@Qualifier("jpaPerucaDao")
	private IPerucaDao perucaDao;
	@Autowired
	@Qualifier("jpaPerucaBaseDao")
	private IPerucaBaseDao dao;
	@Autowired
	@Qualifier("jpaEncomendaDao")
	private IEncomendaDao encomendaDao;
	
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
	
	@RequestMapping("removePerucaBase")
	public String remove (long id) {
		PerucaBase removida = dao.buscaPorId(id);
		dao.remove(removida);
		return "redirect:listaPerucasBase";
	}
	
	//ESSE METODO DEVE, NO FUTURO, MUDAR AUTOMATICAMENTE O STATUS DA ENCOMENDA ASSOCIADA PARA "EM DESENVOLVIMENTO"
	//A SER TESTADO
	@RequestMapping("atualizaChegada")
	public void atualizaChegada(long id) {
		PerucaBase p = dao.buscaPorId(id);
		p.setChegou(true);
		dao.altera(p);
		
		Encomenda e = p.getEncomenda();
		if (e != null)
		{
			boolean todasChegaram = true;
			List<PerucaBase> perucas = e.getPerucasBase();
			if (perucas != null)
			{
				for (int i = 0; i < perucas.size(); i++)
				{
					if (!perucas.get(i).isChegou())
					{
						System.out.println("Peruca de id " + perucas.get(i).getId() + "ainda não chegou na encomenda do personagem " + e.getOrcamento().getPersonagem());
						todasChegaram = false;
					}
				}
				if (todasChegaram)
				{
					e.setStatus(StatusEncomenda.EM_DESENVOLVIMENTO);
					encomendaDao.altera(e);
				}
			}
			else
				System.out.println("array nulo dentro de encomenda, em PerucaBaseControler, atualizaChegada");
		}
		
	}
}

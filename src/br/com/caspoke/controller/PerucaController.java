package br.com.caspoke.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.IPerucaDao;
import br.com.caspoke.model.Cor;
import br.com.caspoke.model.Peruca;

@Controller
@Transactional
public class PerucaController {

	@Autowired
	@Qualifier("jpaPerucaDao")
	private IPerucaDao dao;
	
	@RequestMapping("novaPeruca")
	public String form () {
		return "peruca/formulario";
	}
	
	@RequestMapping("adicionaPeruca")
	public String adiciona(@Valid Peruca p, BindingResult result) {

		System.out.println(p.getSemFranja());
		System.out.println(p.getTemDivisao());
		System.out.println(p.getTemOmbre());
		
		ArrayList<String> cores = new ArrayList<String>(Arrays.asList(p.getCor().split("\\s*,\\s*")));
		if (cores.size() > 1)
		{
			ArrayList<Peruca> perucas = new ArrayList();
			Peruca peruca;
			for (int i = 0; i < cores.size(); i ++)
			{
				peruca = new Peruca();
				peruca.setPreco(p.getPreco());
				peruca.setTamanho(p.getTamanho());
				peruca.setPeso(p.getPeso());
				peruca.setLocal(p.getLocal());
				peruca.setVendedor(p.getVendedor());
				peruca.setLink(p.getLink());
				peruca.setAvaliacao(p.getAvaliacao());
				peruca.setSemFranja(p.getSemFranja());
				peruca.setTemDivisao(p.getTemDivisao());
				peruca.setTemOmbre(p.getTemOmbre());
				peruca.setCor(cores.get(i));
				perucas.add(peruca);
			}
			dao.insereVarias(perucas);
		}
		else {
			dao.insere(p);
		}
		return "redirect:listaPerucas";
	}
	
	@RequestMapping("alteraPeruca")
	public String altera(@Valid Peruca p, BindingResult result) {
		System.out.println(p.getSemFranja());
		System.out.println(p.getTemDivisao());
		System.out.println(p.getTemOmbre());
		
		dao.altera(p);
		return "redirect:listaPerucas";
	}
	
	@RequestMapping("listaPerucas")
	public String lista(Model model) {
		model.addAttribute("perucas", dao.lista());
		model.addAttribute("cores", Cor.values());
		return "peruca/lista";
	}
	
	
	@RequestMapping("removePeruca")
	public String remove(Peruca p) {
		dao.remove(p);
		return "redirect:listaPerucas";
	}
	
	@RequestMapping("mostraPeruca")
	public String mostra(long id, Model model) {
		model.addAttribute("peruca", dao.buscaPorId(id));
		return "peruca/mostra";
	}
	
	@RequestMapping("filtraPorCor")
	public String filtraPorCor(Cor cor, Model model) {
		List<Peruca> perucas = dao.buscaPorCor(cor);
		model.addAttribute("perucas", perucas);
		model.addAttribute("cores", Cor.values());
		model.addAttribute("corSelecionada", cor);
		return "peruca/lista";
	}
	
	@RequestMapping("atualizaAvaliacao")
	public void atualizaAvaliacao(long id, int valor) {
		Peruca p = dao.buscaPorId(id);
		p.setAvaliacao(valor);
		dao.insere(p);
	}
}

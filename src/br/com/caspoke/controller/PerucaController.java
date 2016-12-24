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
	
	@RequestMapping("adicionaPerucaESolicitaImagem")
	public String adicionaESolicita(@Valid Peruca p, BindingResult result, Model model) {

		ArrayList<String> cores = new ArrayList<String>(Arrays.asList(p.getCor().split("\\s*,\\s*")));
		ArrayList<Peruca> perucas = new ArrayList();
		if (cores.size() > 1)
		{
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
			perucas.add(p);
		}
		model.addAttribute("perucas", perucas);
		return "peruca/adiciona-imagem";
	}
	
	@RequestMapping("solicitaImagem")
	public String solicitaImagem(String selecao, Model model) {
		System.out.println(selecao);
		ArrayList<String> dados = new ArrayList<String>(Arrays.asList((selecao.split("\\s*,\\s*"))));
		ArrayList<Peruca> perucas = new ArrayList();
		Peruca p;
		String d[];
		for (int i = 0; i < dados.size(); i++)
		{
			d = dados.get(i).split("::");
			p = new Peruca();
			p.setId(Long.parseLong(d[0]));
			p.setCor(d[1]);
			
			perucas.add(p);
			System.out.println("Adicionou cor " + p.getCor() + "na peruca de id " + p.getId());
		}
		model.addAttribute("perucas", perucas);
		return "peruca/adiciona-imagem";
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
	
	@RequestMapping("testeCores")
	public String testeCores(Model model) {
		List<Peruca> perucas = dao.lista();
		ArrayList<String> coresNaoCadastradas = new ArrayList();
		ArrayList<String> coresCadastradas = new ArrayList();;
		Cor[] cores = Cor.values();
		
		for (int i = 0; i < cores.length; i++)
		{
			coresCadastradas.add(cores[i].toString().replace("_", " "));
		}
		
		
		System.out.println("Cores cadastradas: ");
		for (int i = 0; i < coresCadastradas.size(); i++)
		{
			System.out.println(coresCadastradas.get(i));
		}
		
		for (int i = 0; i < perucas.size(); i++)
		{
			if(!coresCadastradas.contains(perucas.get(i).getCor()))
			{
				if(!coresNaoCadastradas.contains(perucas.get(i).getCor()))
					coresNaoCadastradas.add(perucas.get(i).getCor());
			}
		}
		
		System.out.println("Cores não cadastradas: ");
		for (int i = 0; i < coresNaoCadastradas.size(); i++)
		{
			System.out.println(coresNaoCadastradas.get(i));
		}
		model.addAttribute("coresC", coresCadastradas);
		model.addAttribute("coresNC", coresNaoCadastradas);
		return "cor/lista";
	}
}

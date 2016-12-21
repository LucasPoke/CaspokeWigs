package br.com.caspoke.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.dao.IOrcamentoDao;
import br.com.caspoke.model.Cliente;
import br.com.caspoke.model.Orcamento;

@Controller
@Transactional
public class OrcamentoController {

	@Autowired
	@Qualifier("jpaClienteDao")
	private IClienteDao clienteDao;
	
	@Autowired
	@Qualifier("jpaOrcamentoDao")
	private IOrcamentoDao dao;
	
	@RequestMapping("novoOrcamento")
	public String form(Model model) {
		model.addAttribute("clientes", clienteDao.lista());
		return "orcamento/formulario";
	}
	
	@RequestMapping("listaOrcamentos")
	public String lista(Model model) {
		//ArrayList<Orcamento> orcamentos = dao.getLista();
		List<Orcamento> orcamentos = dao.lista();
		model.addAttribute("orcamentos", orcamentos);
		return "orcamento/lista";
	}
	
	@RequestMapping("removeOrcamento")
	public String remove(Orcamento o) {
		dao.remove(o);
		return "redirect:listaOrcamentos";
	}
	
	@RequestMapping("mostraOrcamento")
	public String mostra (long id, Model model) {
		model.addAttribute("orcamento", dao.buscaPorId(id));
		return "orcamento/mostra";
	}
	
	@RequestMapping("alteraOrcamento")
	public String altera (Orcamento o) {
		dao.altera(o);
		return "redirect:listaOrcamentos";
	}
	
	@RequestMapping("adicionaOrcamento")
	public String adiciona (Orcamento o, long cliente_id) {
		Cliente c = clienteDao.buscaPorId(cliente_id);
		o.setCliente(c);
		dao.insere(o);
		return "redirect:listaOrcamentos";
	}
}

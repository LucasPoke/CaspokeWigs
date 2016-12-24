package br.com.caspoke.controller;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.dao.IOrcamentoDao;
import br.com.caspoke.model.Cliente;
import br.com.caspoke.model.Orcamento;
import br.com.caspoke.model.StatusEncomenda;

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
	public String listaSeparados(Model model) {
		List<Orcamento> aceitos = dao.listaAceitos();
		List<Orcamento> emEspera = dao.listaEmEspera();
		System.out.println("quantidade de aceitos: " + aceitos.size());
		System.out.println("quantidade de em espera: " + emEspera.size());
		model.addAttribute("orcamentosAceitos", aceitos);
		model.addAttribute("orcamentosEmEspera", emEspera);
		return "orcamento/lista";
	}
	
	/*
	@RequestMapping("listaOrcamentos")
	public String lista(Model model) {
		//ArrayList<Orcamento> orcamentos = dao.getLista();
		List<Orcamento> orcamentos = dao.lista();
		model.addAttribute("orcamentos", orcamentos);
		return "orcamento/lista";
	}*/
	
	@RequestMapping("removeOrcamento")
	public String remove(Orcamento o) {
		dao.remove(o);
		return "redirect:listaOrcamentos";
	}
	
	@RequestMapping("mostraOrcamento")
	public String mostra (long id, Model model) {
		model.addAttribute("orcamento", dao.buscaPorId(id));
		model.addAttribute("clientes", clienteDao.lista());
		return "orcamento/mostra";
	}
	
	@RequestMapping("alteraOrcamento")
	public String altera (Orcamento o, long cliente_id) {
		o.setCliente(clienteDao.buscaPorId(cliente_id));
		dao.altera(o);
		return "redirect:listaOrcamentos";
	}
	
	@RequestMapping("adicionaOrcamento")
	public String adiciona (Orcamento o, long cliente_id) {
		if (o.getData_cadastro() == null)
		{
			System.out.println("Cadastrou data atual");
			o.setData_cadastro(Calendar.getInstance());
		}
		Cliente c = clienteDao.buscaPorId(cliente_id);
		o.setCliente(c);
		o.setAceito(false);
		System.out.println("tentando inserir pra " + c.getNome());
		System.out.println("personagem " + o.getPersonagem());
		dao.insere(o);
		return "redirect:listaOrcamentos";
	}
	
	
	
	
	//MODFICACAO "À FORÇA" PRA CONSERTAR PROBLEMAS
	@RequestMapping("aceitoTrue")
	public String aceitoFalse (long id) {
		Orcamento o = dao.buscaPorId(id);
		o.setAceito(true);
		dao.altera(o);
		
		return "redirect:listaOrcamentos";
	}
}

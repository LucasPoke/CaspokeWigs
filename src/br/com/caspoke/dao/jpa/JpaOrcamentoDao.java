package br.com.caspoke.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caspoke.dao.IOrcamentoDao;
import br.com.caspoke.model.Orcamento;

@Repository
public class JpaOrcamentoDao implements IOrcamentoDao {

	@PersistenceContext
	EntityManager manager;
	
	public List<Orcamento> lista() {
		return manager.createQuery("select o from Orcamento o").getResultList();
	}

	//A SER PREENCHIDO
	public List<Orcamento> listaEmEspera() {
		// TODO Auto-generated method stub
		return null;
	}

	public Orcamento buscaPorId(long id) {
		return manager.find(Orcamento.class, id);
	}

	public void insere(Orcamento o) {
		manager.persist(o);
	}

	public void remove(Orcamento o) {
		Orcamento orcamentoARemover = buscaPorId(o.getId());
		manager.remove(orcamentoARemover);
	}

	public void altera(Orcamento o) {
		manager.merge(o);
	}

}

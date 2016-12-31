package br.com.caspoke.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	public List<Orcamento> listaEmEspera() {
		return manager.createQuery("select o from Orcamento o where aceito = false").getResultList();
	}
	
	public List<Orcamento> listaAceitos () {
		return manager.createQuery("select o from Orcamento o where aceito = true").getResultList();
	}

	public List<Orcamento> listaEmEsperaPorCliente (long id) {
		Query q = manager.createQuery("select o from Orcamento o where aceito = false and cliente_id=:id");
		q.setParameter("id", id);
		List<Orcamento> l = q.getResultList();
		System.out.println("resultado: " + l.size());
		return l;
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

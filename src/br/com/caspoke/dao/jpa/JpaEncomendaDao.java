package br.com.caspoke.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caspoke.dao.IEncomendaDao;
import br.com.caspoke.model.Encomenda;

@Repository
public class JpaEncomendaDao implements IEncomendaDao {

	@PersistenceContext
	EntityManager manager;
	
	public List<Encomenda> lista() {
		return manager.createQuery("select e from Encomenda e").getResultList();
	}

	public Encomenda buscaPorId(long id) {
		return manager.find(Encomenda.class, id);
	}

	public void insere(Encomenda e) {
		manager.persist(e);
	}

	public void remove(Encomenda e) {
		manager.remove(e);
	}

	public void altera(Encomenda e) {
		manager.merge(e);
	}

}

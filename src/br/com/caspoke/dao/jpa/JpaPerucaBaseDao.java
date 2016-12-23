package br.com.caspoke.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caspoke.dao.IPerucaBaseDao;
import br.com.caspoke.model.PerucaBase;

@Repository
public class JpaPerucaBaseDao implements IPerucaBaseDao {

	@PersistenceContext
	EntityManager manager;
	
	public List<PerucaBase> lista() {
		return manager.createQuery("select p from PerucaBase p").getResultList();
	}

	public PerucaBase buscaPorId(long id) {
		return manager.find(PerucaBase.class, id);
	}

	public void insere(PerucaBase p) {
		manager.persist(p);
	}

	public void remove(PerucaBase p) {
		PerucaBase deletada = buscaPorId(p.getId());
		manager.remove(deletada);
	}

	public void altera(PerucaBase p) {
		manager.merge(p);
	}
}

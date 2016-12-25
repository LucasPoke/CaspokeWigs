package br.com.caspoke.dao.jpa;

import java.util.ArrayList;
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

	//MELHORAR ESSA BUSCA
	public List<PerucaBase> listaAssociadas() {
		List<PerucaBase> todas = manager.createQuery("select p from PerucaBase p").getResultList();
		List<PerucaBase> perucas = new ArrayList();
		for (int i = 0; i < todas.size(); i++)
		{
			if (todas.get(i).getEncomenda() != null)
				perucas.add(todas.get(i));
		}
		return perucas;
	}

	//MELHORAR ESSA BUSCA
	public List<PerucaBase> listaNaoAssociadas() {
		List<PerucaBase> todas = manager.createQuery("select p from PerucaBase p").getResultList();
		List<PerucaBase> perucas = new ArrayList();
		for (int i = 0; i < todas.size(); i++)
		{
			if (todas.get(i).getEncomenda() == null)
				perucas.add(todas.get(i));
		}
		return perucas;
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

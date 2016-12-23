package br.com.caspoke.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caspoke.dao.IPerucaDao;
import br.com.caspoke.model.Cor;
import br.com.caspoke.model.Peruca;

@Repository
public class JpaPerucaDao implements IPerucaDao {
	
	@PersistenceContext
	EntityManager manager;
	
	public List<Peruca> lista() {
		return manager.createQuery("select p from Peruca p order by avaliacao desc").getResultList();
	}

	public Peruca buscaPorId(long id) {
		return manager.find(Peruca.class, id);
	}

	public void insere(Peruca p) {
		manager.persist(p);
	}

	public void remove(Peruca p) {
		Peruca deletada = buscaPorId(p.getId());
		manager.remove(deletada);
	}

	public void altera(Peruca p) {
		manager.merge(p);
	}
	
	//A TESTAR (talvez só fique atualizando cores na mesma peruca)
	public void insereVarias(ArrayList<Peruca> perucas) {
		System.out.println("numero de perucas; " + perucas.size());
		for (int i = 0; i < perucas.size(); i++)
		{
			insere(perucas.get(i));
		}
	}
	
	public List<Peruca> buscaPorCor(Cor cor) {
		String corTexto = cor.toString();
		corTexto = corTexto.replace("_", " ");
		Query q = manager.createQuery("select p from Peruca p where p.cor = :c order by avaliacao desc");
		q.setParameter("c", corTexto);
		
		List<Peruca> resultado = q.getResultList();
		return resultado;
	}
}

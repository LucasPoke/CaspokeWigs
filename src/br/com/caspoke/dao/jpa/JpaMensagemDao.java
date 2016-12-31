package br.com.caspoke.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caspoke.dao.IMensagemDao;
import br.com.caspoke.model.Mensagem;

@Repository
public class JpaMensagemDao implements IMensagemDao{

	@PersistenceContext
	EntityManager manager;

	public Mensagem buscaPorId(long id) {
		return manager.find(Mensagem.class, id);
	}

	public void insere(Mensagem m) {
		manager.persist(m);
	}

	public void remove(Mensagem m) {
		Mensagem mm = buscaPorId(m.getId());
		manager.remove(mm);
	}

	public void altera(Mensagem m) {
		manager.merge(m);
	}

}

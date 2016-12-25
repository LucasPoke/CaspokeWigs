package br.com.caspoke.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.model.Cliente;

@Repository
public class JpaClienteDao implements IClienteDao {

	@PersistenceContext
	EntityManager manager;
	
	public List<Cliente> lista() {
		return manager.createQuery("select c from Cliente c").getResultList();
	}

	public List<Cliente> buscaPorNome(String nome) {
		Query q = manager.createQuery("select c from Cliente as c where c.nome = :nome");
		q.setParameter("nome", nome);
		
		List<Cliente> resultado = q.getResultList();
		return resultado;
	}

	public Cliente buscaPorId(long id) {
		return manager.find(Cliente.class, id);
	}

	public Cliente buscaPorEmail(Cliente c) {
		Query q = manager.createQuery("select c from Cliente as c where c.email = :email and c.senha = :senha");
		q.setParameter("email", c.getEmail());
		q.setParameter("senha", c.getSenha());
		
		List<Cliente> resultado = q.getResultList();
		if (resultado.size() > 0)
			return resultado.get(0);
		else
			return null;
	}

	public void insere(Cliente c) {
		manager.persist(c);
	}

	public void remove(Cliente c) {
		Cliente clienteARemover = buscaPorId(c.getId());
		manager.remove(clienteARemover);
	}

	public void altera(Cliente c) {
		manager.merge(c);
	}

}

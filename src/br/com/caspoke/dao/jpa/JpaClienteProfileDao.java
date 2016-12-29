package br.com.caspoke.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caspoke.dao.IClienteProfileDao;
import br.com.caspoke.model.ClienteProfile;

@Repository
@Transactional
public class JpaClienteProfileDao implements IClienteProfileDao {

	@PersistenceContext
	EntityManager manager;
	
	public ClienteProfile buscaPorId(int id) {
		return manager.find(ClienteProfile.class, id);
	}
	 
	public ClienteProfile buscaPorTipo(String tipo) {
		Query q = manager.createQuery("select c from ClienteProfile as c where c.tipo = :tipo");
		q.setParameter("tipo", tipo);
		
		return (ClienteProfile) q.getSingleResult();
	}
	     
	@SuppressWarnings("unchecked")
	public List<ClienteProfile> lista(){
		Query q = manager.createQuery("select c from ClienteProfile as c order by tipo asc");
		return (List<ClienteProfile>)q.getResultList();
	}
}

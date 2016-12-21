package br.com.caspoke.dao.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caspoke.model.Cliente;

public class AdicionaClienteTeste {

	public static void main(String[] args) {
	    Cliente c = new Cliente();
	    c.setNome("Caspoke");
	    c.setLogin("admin2");
	    c.setSenha("admin");
	    c.setEmail("poke.lrs@gmail.com");
	    c.setData(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CaspokeWigsPU");
	    EntityManager manager = factory.createEntityManager();
	    
	    manager.getTransaction().begin();
	    manager.persist(c);
	    manager.getTransaction().commit();
	    
	    System.out.println("Id do cliente: " + c.getId());
	    factory.close();
	  }
}

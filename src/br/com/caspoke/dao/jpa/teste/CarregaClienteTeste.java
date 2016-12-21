package br.com.caspoke.dao.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caspoke.model.Cliente;

public class CarregaClienteTeste {

	public static void main (String args[]) {
		
	EntityManagerFactory factory = Persistence.
	        createEntityManagerFactory("Cliente");
	    EntityManager manager = factory.createEntityManager();

	    Cliente encontrada = manager.find(Cliente.class, 1L);
	    
	    System.out.println(encontrada.getNome());

	    manager.close();
	}
}

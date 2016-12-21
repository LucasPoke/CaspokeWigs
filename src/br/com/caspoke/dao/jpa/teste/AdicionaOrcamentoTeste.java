package br.com.caspoke.dao.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caspoke.model.Cliente;
import br.com.caspoke.model.Orcamento;

public class AdicionaOrcamentoTeste {
	public static void main(String[] args) {
	    Orcamento o = new Orcamento();
		o.setPersonagem("Oi");
		o.setSerie("sei la");
		o.setData(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CaspokeWigsPU");
	    EntityManager manager = factory.createEntityManager();
	    
	    manager.getTransaction().begin();
	    Cliente c = manager.find(Cliente.class, (long)2);
	    System.out.println("Achou cliente: " + c.getNome());
	    o.setCliente(c);
	    manager.persist(o);
	    manager.getTransaction().commit();
	    
	    
	    
	    //System.out.println("Id do cliente: " + c.getId());
	    factory.close();
	  }
}

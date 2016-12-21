package br.com.caspoke.dao.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caspoke.model.Orcamento;

public class CarregaOrcamentoTeste {
		public static void main (String args[]) {
		
		EntityManagerFactory factory = Persistence.
		        createEntityManagerFactory("CaspokeWigsPU");
		    EntityManager manager = factory.createEntityManager();

		    Orcamento o = manager.find(Orcamento.class, (long)1);
		    
		    System.out.println("Nome do cliente associado a esse orcamento: " + o.getCliente().getNome());
		    manager.close();
		}
}

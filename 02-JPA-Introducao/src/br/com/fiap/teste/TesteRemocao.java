package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Pizza;

public class TesteRemocao {
 
	public static void main(String[] args) {
		//remover uma pizza
		
		EntityManagerFactory fabrica =
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
	EntityManager em = fabrica.createEntityManager();
	
	Pizza pizza = em.find(Pizza.class, 1);
	
	em.getTransaction().begin();
	em.remove(pizza);
	em.getTransaction().commit();
	System.out.println("Pizza excluida");
	System.exit(0);
	}
}

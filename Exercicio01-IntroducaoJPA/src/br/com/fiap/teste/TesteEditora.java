package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Editora;

public class TesteEditora {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica=
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

	    EntityManager em= fabrica.createEntityManager();
	    
	    
	    Editora ed= new Editora(0,"452796185911","Moderna","Paulista 21581");
	    
	    em.getTransaction().begin();
	    em.persist(ed);
	    em.getTransaction().commit();
	    System.out.println("Editora Cadastrada!");
	}

}

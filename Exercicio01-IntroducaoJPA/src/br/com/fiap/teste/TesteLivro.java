package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Livro;

public class TesteLivro {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		EntityManager em= fabrica.createEntityManager();
		
		Livro livro = new Livro(484141,"Mágico de Oz",45,new GregorianCalendar(2017,Calendar.FEBRUARY,17));
		 em.getTransaction().begin();
		 em.persist(livro);
		 em.getTransaction().commit();
		 
		 System.out.println("Livro Cadastrado!");
	}

}

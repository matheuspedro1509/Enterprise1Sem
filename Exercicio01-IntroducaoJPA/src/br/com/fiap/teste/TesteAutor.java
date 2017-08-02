package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Autor;
import br.com.fiap.bean.Sexo;

public class TesteAutor {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		Autor autor = new Autor(0,"Machado",Sexo.MASCULINO,"De Assis",new GregorianCalendar(1839,Calendar.JUNE,21));
		
		em.getTransaction().begin();
		em.persist(autor);
		em.getTransaction().commit();
		
		System.out.println("Autor Cadastrado!");
	}
}

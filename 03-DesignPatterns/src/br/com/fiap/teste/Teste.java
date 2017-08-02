package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.dao.AnimalDAO;
import br.com.fiap.dao.impl.AnimalDAOImpl;
import br.com.fiap.entity.Animal;
import br.com.fiap.entity.Porte;
import br.com.fiap.exception.DBException;

public class Teste {

	public static void main(String[] args) {
		
		Animal animal = new Animal(0, null, "Pug", 
			Porte.PEQUENO, null, 
			new GregorianCalendar(2013,Calendar.MARCH,3));
		
		AnimalDAO dao = new AnimalDAOImpl();
		
		try {
			dao.cadastrar(animal);
			System.out.println("Animal cadastrado!");
		} catch (DBException e) {
			System.out.println("Erro ao cadastrar");
		}
		
		System.exit(0);
	}
	
}
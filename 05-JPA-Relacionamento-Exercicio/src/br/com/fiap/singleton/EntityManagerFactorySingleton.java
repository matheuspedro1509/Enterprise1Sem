package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//atributo estatico
	private static EntityManagerFactory fabrica;
	
	//construtor privado
	private EntityManagerFactorySingleton(){
		
	}
	
	//método estático .getInstance
	public static EntityManagerFactory getInstance(){
		if(fabrica==null){
			fabrica=Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return fabrica;
	}
}

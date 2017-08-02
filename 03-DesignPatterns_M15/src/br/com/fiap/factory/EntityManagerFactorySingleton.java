package br.com.fiap.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//atributo private e estatico que sera unico
	private static EntityManagerFactory fabrica;

	
	//contrutor privado
	private EntityManagerFactorySingleton() {
		
	}
	//  metodo que retorna a unica instancia de EntityManagerFactory
	public static EntityManagerFactory getInstance(){
		if(fabrica==null);
		{
			//inicializa a fabrica
			fabrica=Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return fabrica;
	}
}

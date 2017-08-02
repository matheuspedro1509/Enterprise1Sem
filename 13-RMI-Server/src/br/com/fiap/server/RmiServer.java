package br.com.fiap.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.fiap.bo.impl.CambioBOImpl;

public class RmiServer {

	public static void main(String[] args) throws Exception{
		
		Registry registry= 
											// numero da porta
					LocateRegistry.createRegistry(123);
		
		registry.bind("churros",new CambioBOImpl());
	}
}

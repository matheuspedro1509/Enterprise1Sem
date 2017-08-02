package br.com.fiap.rmi;

import java.rmi.Naming;

import br.com.fiap.bo.CambioBO;

public class Client {

	public static void main(String[] args) throws Exception{
		
		CambioBO bo = (CambioBO) Naming.lookup("rmi://127.0.0.1:123/churros");
		
		double real = bo.converterBitCoinParaReal(1);
		
		System.out.println("Reais "+ real);
		
	}
}

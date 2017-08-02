package br.com.fiap.factory;

import java.sql.Connection;

import br.com.fiap.annotation.Banco;

@Banco(url="oracle.fiap.com.br")

public class ConnectionFactory {
	
	@Banco(url="989.158.15.1")
	public Connection getConnection(){
		return null;
	}
}

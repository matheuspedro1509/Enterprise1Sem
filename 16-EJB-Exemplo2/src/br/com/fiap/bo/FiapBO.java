package br.com.fiap.bo;

import javax.ejb.Remote;

@Remote
public interface FiapBO {

	double calcularPS(double nac,double am,double enade);
	
	double calcularEnade(double nac, double am,double ps);
}

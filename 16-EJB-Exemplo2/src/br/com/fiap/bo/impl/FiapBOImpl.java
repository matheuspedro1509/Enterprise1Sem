package br.com.fiap.bo.impl;

import javax.ejb.Stateless;

import br.com.fiap.bo.FiapBO;

@Stateless
public class FiapBOImpl implements FiapBO{

	@Override
	public double calcularPS(double nac, double am,double enade) {
		return (6-(nac*0.2+(am*0.4+enade *0.6)*0.3))*2;
	}

	@Override
	public double calcularEnade(double nac, double am, double ps) {
		return (6 - (nac*0.2 + ps*0.5 +am*0.12)*0.18);
	}

}

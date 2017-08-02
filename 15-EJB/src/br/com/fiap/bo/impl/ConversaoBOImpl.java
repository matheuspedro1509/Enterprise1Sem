package br.com.fiap.bo.impl;

import javax.ejb.Stateless;

import br.com.fiap.bo.ConversaoBO;

@Stateless
public class ConversaoBOImpl implements ConversaoBO{

	
	@Override
	public double converterKmMilhas(double km) {
		return km*1.6;
	}

}

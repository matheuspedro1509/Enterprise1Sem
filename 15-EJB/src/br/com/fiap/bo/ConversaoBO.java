package br.com.fiap.bo;

import javax.ejb.Local;

@Local
public interface ConversaoBO {
	
	double converterKmMilhas(double km);

}

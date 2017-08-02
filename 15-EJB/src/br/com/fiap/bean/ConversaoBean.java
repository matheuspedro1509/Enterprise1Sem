package br.com.fiap.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.ConversaoBO;

@ManagedBean
public class ConversaoBean {

	private double km,milha;

	@EJB
	private ConversaoBO bo;
	
	public void converter(){
		milha = bo.converterKmMilhas(km);
	}
	
	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getMilha() {
		return milha;
	}

	public void setMilha(double milha) {
		this.milha = milha;
	}
	
}

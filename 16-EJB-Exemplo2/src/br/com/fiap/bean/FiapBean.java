package br.com.fiap.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.FiapBO;

@ManagedBean
public class FiapBean {

	private double am,nac,enade,ps;

	@EJB	
	private FiapBO bo;
	
	public void calcular(){
		ps=bo.calcularPS(nac, am, enade);
	}
	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

	public double getNac() {
		return nac;
	}

	public void setNac(double nac) {
		this.nac = nac;
	}

	public double getEnade() {
		return enade;
	}

	public void setEnade(double enade) {
		this.enade = enade;
	}

	public double getPs() {
		return ps;
	}

	public void setPs(double ps) {
		this.ps = ps;
	}
}

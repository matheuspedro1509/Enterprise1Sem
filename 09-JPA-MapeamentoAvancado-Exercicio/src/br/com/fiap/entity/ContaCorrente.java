package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_CORRENTE_09")
public class ContaCorrente extends Conta{

	@Column(name="VL_TARIFA",nullable=false)
	private int tarifa;
	
	@Column(name="VL_CHEQUE_ESPECIAL")
	private double chequeEspecial;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(Agencia agencia, double valorSaldo, int tarifa, double chequeEspecial) {
		super(agencia, valorSaldo);
		this.tarifa = tarifa;
		this.chequeEspecial = chequeEspecial;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}
	
	
}

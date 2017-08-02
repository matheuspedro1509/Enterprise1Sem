package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_POUPANCA_09")
public class ContaPoupanca extends Conta{

	@Column(name="VL_RENDIMENTO",nullable=false)
	private double valorRendimento;

	
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(Agencia agencia, double valorSaldo, double valorRendimento) {
		super(agencia, valorSaldo);
		this.valorRendimento = valorRendimento;
	}

	public double getValorRendimento() {
		return valorRendimento;
	}

	public void setValorRendimento(double valorRendimento) {
		this.valorRendimento = valorRendimento;
	}
	
	
}

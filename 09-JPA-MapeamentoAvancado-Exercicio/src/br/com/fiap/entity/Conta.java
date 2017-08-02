package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@IdClass(ContaPK.class)
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="T_CONTA_09")
public class Conta {

	@Id
	@Column(name="NR_CONTA")
	@SequenceGenerator(name="seqConta",sequenceName="SQ_CONTA",allocationSize=1)
	@GeneratedValue(generator="seqConta",strategy=GenerationType.SEQUENCE)
	private int numero;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="NR_AGENCIA")
	private Agencia agencia;
	
	@Column(name="VL_SAlDO",nullable=false)
	private double valorSaldo;

	public Conta() {
		super();
	}

	public Conta(Agencia agencia, double valorSaldo) {
		super();
		this.agencia = agencia;
		this.valorSaldo = valorSaldo;
	}

	public double getValorSaldo() {
		return valorSaldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public void setValorSaldo(double valorSaldo) {
		this.valorSaldo = valorSaldo;
	}
	
}

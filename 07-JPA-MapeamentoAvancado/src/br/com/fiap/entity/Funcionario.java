package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_FUNCIONARIO")
@SecondaryTable(name="T_DADO_FUNCIONARIO")
@SequenceGenerator(name="seqFuncionario",sequenceName="SQ_FUNCIONARIO",allocationSize=1)
public class Funcionario {

	@Id
	@Column(name="CD_FUNCIONARIO")
	@GeneratedValue(generator="seqFuncionario",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_FUNCIONARIO",nullable=false)
	private String nome;

	@Column(name="VL_SALARIO",table="T_DADO_FUNCIONARIO")
	private double salario;
	
	@Column(name="NR_CONTA",table="T_DADO_FUNCIONARIO")
	private String numeroConta;
	
	public Funcionario(String nome) {
		super();
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
}

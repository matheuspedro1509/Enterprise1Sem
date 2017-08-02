package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa{

	@Column(name="NR_CPF",nullable=false)
	private int cpf;
	
	@Column(name="DS_SEXO",nullable=false)
	private Sexo sexo;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, String endereco, int cpf, Sexo sexo) {
		super(nome, endereco);
		this.cpf = cpf;
		this.sexo = sexo;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
}

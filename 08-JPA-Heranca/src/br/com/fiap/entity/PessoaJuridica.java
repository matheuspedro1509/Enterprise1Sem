package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa{
	
	@Column(name="NR_CNPJ",nullable=false)
	private int cnpj;
	
	@Column(name="NM_FANTASIA",nullable=false)
	private String nomeFantasia;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, String endereco, int cnpj, String nomeFantasia) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
}

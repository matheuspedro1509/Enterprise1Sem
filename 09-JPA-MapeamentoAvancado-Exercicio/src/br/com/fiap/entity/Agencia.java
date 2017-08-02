package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_AGENCIA_09")
@SequenceGenerator(name="seqName",sequenceName="SQ_T_AGENCIA",allocationSize=1)
public class Agencia {

	@Id
	@GeneratedValue(generator="seqName",strategy=GenerationType.SEQUENCE)
	@Column(name="NR_AGENCIA")
	private int agencia;
	
	@Column(name="DS_ENDERECO")
	private String endereco;
	
	public Agencia() {
		super();
	}

	public Agencia(int agencia, String endereco) {
		super();
		this.agencia = agencia;
		this.endereco = endereco;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}

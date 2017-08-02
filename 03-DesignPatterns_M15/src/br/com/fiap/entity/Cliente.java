package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="TB_CLIENTE")
@SequenceGenerator(name="seqCliente", sequenceName="SQ_TB_CLIENTE", allocationSize=1)
public class Cliente {

	@Id
	@Column(name="CD_CLIENTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCliente")
	private int codigo;
	
	@Column(name="NM_CLIENTE")
	private String nome;
	

	public Cliente() {
		super();
	}

	public Cliente(int codigo, String nome) {
		super();
		this.codigo = codigo;
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
	
	
}

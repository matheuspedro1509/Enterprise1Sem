package br.com.fiap.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_EDITORA")
@SequenceGenerator(name="seqEditora",
sequenceName="SQ_EITORA",allocationSize=1)
public class Editora {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqEditora")
	private int id;
	
	@Column(length=100,nullable=false)
	private String cnpj;
	
	@Column(length=300,nullable=false)
	private String nome;
	
	@Column(length=400,nullable=true)
	private String endereco;

	
	
	public Editora() {
		super();
	}

	public Editora(int id, String cnpj, String nome, String endereco) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}

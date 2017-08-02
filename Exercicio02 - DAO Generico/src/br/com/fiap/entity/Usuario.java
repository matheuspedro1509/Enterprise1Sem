package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
@SequenceGenerator(name="seqUsuario",
sequenceName="SQ_USUARIO",allocationSize=1)
public class Usuario {
	
	@Id
	@GeneratedValue(generator="seqUsuario",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nome_usuario",nullable=false)
	private String usuario;
	
	@Column(length=300,nullable=false)
	private String nome;
	
	@Column(length=300,nullable=true)
	private String sobrenome;
	
	@Column(nullable=false,length=20)
	private String cpf;

	public Usuario(int id, String usuario, String nome, String sobrenome, String cpf) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}

	public Usuario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

}

package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TECNICO")
@SequenceGenerator(name="seqTecnico",sequenceName="SQ_TECNICO",allocationSize=1)
public class Tecnico {
	
	@Id
	@GeneratedValue(generator="seqTecnico",strategy=GenerationType.SEQUENCE)
	@Column(name="CD_TECNICO")
	private int codigo;
	
	@Column(name="NM_TECNICO",nullable=false)
	private String nome;
	
	//mappedBy --> nome do ATRIBUTO que mapeia o relacionamento (na classe time)
	//Fetch lazy --> na hora da pesquisa tras somente o tecnico, se fosse o eager,
	// voltaria o time tambem
	// quanto tem o mapped by nao pode colocar o join column
	@OneToOne(mappedBy="tecnico",fetch=FetchType.LAZY)
	private Time time;
	
	public Tecnico() {
		super();
	}
	
	public Tecnico(String nome) {
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	

}

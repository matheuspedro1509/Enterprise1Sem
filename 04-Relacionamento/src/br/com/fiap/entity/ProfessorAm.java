package br.com.fiap.entity;


import java.util.List;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PROFESSOR_AM")
@SequenceGenerator(name="seqProfessor",allocationSize=1,sequenceName="SQ_PROFESSOR")
public class ProfessorAm {

	@Id
	@GeneratedValue(generator="seqProfessor",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_PROFESSOR",nullable=false)
	private String nome;
	
	@Column(name="DT_ADMISSAO",nullable=false)
	@Temporal(TemporalType.DATE)//somente a data
	private Calendar dataAdsmissao;
	
	@Column(name="VL_SALARIO")
	private float salario;
	
	@ManyToMany
	@JoinTable(name="TB_PROFESSOR_PROJETOS",
		joinColumns=@JoinColumn(name="CD_PROFESSOR"),
		inverseJoinColumns=@JoinColumn(name="CD_PROJETO"))
	private List<ProjetoAm> projetos;

	public ProfessorAm() {
		super();
	}

	public ProfessorAm(int codigo, String nome, Calendar dataAdsmissao, float salario,
			List<ProjetoAm> projetos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataAdsmissao = dataAdsmissao;
		this.salario = salario;
		this.projetos = projetos;
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

	public Calendar getDataAdsmissao() {
		return dataAdsmissao;
	}

	public void setDataAdsmissao(Calendar dataAdsmissao) {
		this.dataAdsmissao = dataAdsmissao;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public List<ProjetoAm> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<ProjetoAm> projetos) {
		this.projetos = projetos;
	}

}

package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_GRUPO_AM")
@SequenceGenerator(name="seqGrupo", sequenceName="SQ_TB_GRUPO_AM",allocationSize=1)
public class GrupoAm {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqGrupo")
	@Column(name="CD_GRUPO")
	private int codigo;
	
	@Column(name="NM_GRUPO",nullable=false,length=50)
	private String nome;

	@OneToOne(mappedBy="grupo",fetch=FetchType.LAZY)
	private ProjetoAm projeto;
	
	@OneToMany(mappedBy="grupo",cascade=CascadeType.PERSIST)
	private List<AlunoAm> alunos= new ArrayList<AlunoAm>();
	
	//adicionar os alunos no grupo
	public void addAluno(AlunoAm aluno){
		//Adiciona o aluno na lista
		alunos.add(aluno);
		//seta o grupo do aluno
		aluno.setGrupo(this);
	}
	
	public GrupoAm() {
		super();
	}

	public GrupoAm(int codigo, String nome) {
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

	public ProjetoAm getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoAm projeto) {
		this.projeto = projeto;
	}

	public List<AlunoAm> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoAm> alunos) {
		this.alunos = alunos;
	}
	
	
	
	
}

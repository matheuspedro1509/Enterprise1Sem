package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_EXEMPLAR")
@SequenceGenerator(name="seqExemplar",
sequenceName="SQ_EXEMPLAR",allocationSize=1)
public class Exemplar {

	@Id
	@GeneratedValue(generator="seqExemplar",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_aquisicao", nullable=true)
	private Calendar dtAquisicao;
	
	@Column(nullable=false)
	private Situacao situacao;
	

	public Exemplar() {
		super();
	}

	public Exemplar(int id, Calendar dtAquisicao, Situacao situacao) {
		super();
		this.id = id;
		this.dtAquisicao = dtAquisicao;
		this.situacao = situacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDtAquisicao() {
		return dtAquisicao;
	}

	public void setDtAquisicao(Calendar dtAquisicao) {
		this.dtAquisicao = dtAquisicao;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	

}


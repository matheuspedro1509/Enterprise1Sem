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
@Table(name="TB_EMPRESTIMO")
@SequenceGenerator(name="seqEmprestimo",
sequenceName="SQ_EMPRESTIMO",allocationSize=1)
public class Emprestimo {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqEmprestimo")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_emprestimo", nullable=false)
	private Calendar dtEmprestimo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_retorno", nullable=false)
	private Calendar dtRetorno;

	
	public Emprestimo(int id, Calendar dtEmprestimo, Calendar dtRetorno) {
		super();
		this.id = id;
		this.dtEmprestimo = dtEmprestimo;
		this.dtRetorno = dtRetorno;
	}

	public Emprestimo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDtEmprestimo() {
		return dtEmprestimo;
	}

	public void setDtEmprestimo(Calendar dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
	}

	public Calendar getDtRetorno() {
		return dtRetorno;
	}

	public void setDtRetorno(Calendar dtRetorno) {
		this.dtRetorno = dtRetorno;
	}
	
	
}

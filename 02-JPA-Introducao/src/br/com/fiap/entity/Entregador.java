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
@Table(name="TB_ENTREGADOR")
@SequenceGenerator(name="seqEntregador",
sequenceName="SQ_ENTREGADOR",allocationSize=1)
public class Entregador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqEntregador")
	@Column(name="CD_ENTREGADOR")
	private int codigo;
	
	@Column(nullable=false,name="NM_ENTREGADOR")
	private String nome;
	
	@Column(name="DS_PLACA")
	private String placa;
	
	@Column(name="NR_HABILITACAO")
	private long habilitacao;
	
	@Column(nullable=false,name="NR_CPF")
	private long cpf;
	
	@Column(name="DT_CONTRATACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dt_contratacao;
	
	@Column(name="DS_PERIODO")
	private Periodo periodo;

	
	public Entregador() {
		super();
	}

	public Entregador(int codigo, String nome, String placa, long habilitacao, long cpf, Calendar dt_contratacao,
			Periodo periodo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.placa = placa;
		this.habilitacao = habilitacao;
		this.cpf = cpf;
		this.dt_contratacao = dt_contratacao;
		this.periodo = periodo;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public long getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(long habilitacao) {
		this.habilitacao = habilitacao;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public Calendar getDt_contratacao() {
		return dt_contratacao;
	}

	public void setDt_contratacao(Calendar dt_contratacao) {
		this.dt_contratacao = dt_contratacao;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	
}

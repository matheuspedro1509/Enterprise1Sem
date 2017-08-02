package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostPersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table(name="TB_PIZZA")
//criando a sequencia, primeiro nome para o java e segundo para o banco
@SequenceGenerator(name="seqPizza",
sequenceName="SQ_PIZZA",allocationSize=1)
public class Pizza {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqPizza")
	@Column(name="CD_PIZZA")
	private int codigo;
	
	private double preco;
	
	@Column(nullable=false,name="DS_SABOR")
	private String sabor;
	
	@Column(name="DS_BORDA")
	private BordaRecheada bordaRecheada;
	
	private TamanhoPizza tamanho;
	
	@Column(name="DT_ENTREGA",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEntrega;
	
	@Transient //Não será uma coluna na tabela
	private String comentario;
	
	@Lob
	private byte[] foto;

	
	public Pizza() {
		super();
	}

	public Pizza(int codigo, double preco, String sabor, BordaRecheada bordaRecheada, TamanhoPizza tamanho,
			Calendar dataEntrega, String comentario, byte[] foto) {
		super();
		this.codigo = codigo;
		this.preco = preco;
		this.sabor = sabor;
		this.bordaRecheada = bordaRecheada;
		this.tamanho = tamanho;
		this.dataEntrega = dataEntrega;
		this.comentario = comentario;
		this.foto = foto;
	}
	@PostPersist
	public void log(){
		System.out.println("Cadastrando uma pizza");
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public BordaRecheada getBordaRecheada() {
		return bordaRecheada;
	}

	public void setBordaRecheada(BordaRecheada bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}

	public TamanhoPizza getTamanho() {
		return tamanho;
	}

	public void setTamanho(TamanhoPizza tamanho) {
		this.tamanho = tamanho;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
}

package br.com.fiap.bean;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_LIVRO")
public class Livro {

	@Id
	private int isbn;
	
	@Column(nullable=false,length=200)
	private String titulo;
	
	@Column(nullable=true)
	private float preco;
	
	@Column(nullable=true)
	@Temporal(TemporalType.DATE)
	private Calendar dtLancamento;
	
	@Lob
	private Byte[] capa;

	
	public Livro() {
		super();
	}

	public Livro(int isbn, String titulo, float preco, Calendar dtLancamento) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.dtLancamento = dtLancamento;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Calendar getDtLancamento() {
		return dtLancamento;
	}

	public void setDtLancamento(Calendar dtLancamento) {
		this.dtLancamento = dtLancamento;
	}

	public Byte[] getCapa() {
		return capa;
	}

	public void setCapa(Byte[] capa) {
		this.capa = capa;
	}
	
	
	
}

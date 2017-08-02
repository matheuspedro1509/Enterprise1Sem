package br.com.fiap.teste;

import br.com.fiap.annotation.Tabela;
import br.com.fiap.beans.Aluno_Exercicio;

public class Exercicio {

	public static void main(String[] args) {
	
		//recuperar a anotaçao
		Tabela anotacao= Aluno_Exercicio.class.getAnnotation(Tabela.class);
		System.out.println("SELECT * FROM" + anotacao.nome());
	}
	
}

package br.com.fiap.main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import br.com.fiap.bean.Pessoa;

public class DeserealizacaoTeste {

	public static void main(String[] args) throws Exception{
		
		FileInputStream fileiput= new FileInputStream("filepessoa");
		
		ObjectInputStream objectInput= new ObjectInputStream(fileiput);
		
		Pessoa pessoa = (Pessoa) objectInput.readObject();
		
		objectInput.close();
		fileiput.close();
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getIdade());
	}
}

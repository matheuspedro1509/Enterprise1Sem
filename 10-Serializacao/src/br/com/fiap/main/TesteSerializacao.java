package br.com.fiap.main;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import br.com.fiap.bean.Pessoa;

public class TesteSerializacao {

	public static void main(String[] args)throws Exception {
		
		Pessoa pessoa = new Pessoa("Rita",30);
		
		FileOutputStream filOut= new FileOutputStream("filepessoa");
		
		ObjectOutputStream objectStream = new ObjectOutputStream(filOut);
		
		objectStream.writeObject(pessoa);
		
		filOut.close();
		objectStream.close();
		
		System.out.println("Objeto serializado");
	}
}

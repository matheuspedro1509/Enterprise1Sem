package br.com.fiap.socket;

import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.fiap.bean.Pessoa;

public class SocketClient {

	public static void main(String[] args) throws Exception{
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("mat");
		pessoa.setIdade(18);
		
		Socket socket = new Socket("127.0.0.1",1234);
		
		ObjectOutputStream objectOut= new ObjectOutputStream(socket.getOutputStream());
		
		objectOut.writeObject(pessoa);
		System.out.println("Pessoa serializada!");
		
		socket.close();
		objectOut.close();
	}
}

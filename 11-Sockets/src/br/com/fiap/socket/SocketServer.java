package br.com.fiap.socket;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.fiap.bean.Pessoa;

public class SocketServer {

	//Ler o metodo enviado pela rede(socket)
	public static void main(String[] args) throws Exception{
		
		ServerSocket server = new ServerSocket(1234);
		
		System.out.println("Aguardando....");
		//aguardando a conexao
		Socket socket = server.accept();
		
		ObjectInputStream objectInput= new 
				ObjectInputStream(socket.getInputStream());
		
		Pessoa pessoa = (Pessoa) objectInput.readObject();
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getIdade());
		
		objectInput.close();
	}
}

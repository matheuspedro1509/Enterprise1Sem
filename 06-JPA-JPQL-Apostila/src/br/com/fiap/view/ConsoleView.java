package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;

public class ConsoleView {

	public static void main(String[] args) {

		EntityManager em= EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Executar a listagem de pacotes
		PacoteDAO dao= new PacoteDAOImpl(em);
		List<Pacote>listar =dao.listar();
		System.out.println("LISTAGEM");
		for(Pacote pacote: listar){
			System.out.println(pacote.getId()+ " - "+ pacote.getDescricao());
		}
		System.out.println("BUSCA POR QUANTIDADE DE DIAS MINIMO");
		listar=dao.buscarPorQuantidadeDiasMinimo(8);
		for (Pacote pacote : listar) {
			System.out.println(pacote.getId()+ " - "+ pacote.getDescricao()+ " - "+ pacote.getQtdDias());
		}
		
		//Listar todos os clientes Ex01 da apostila 06
		ClienteDAO daoCliente = new ClienteDAOImpl(em);
		List<Cliente>listaCliente=daoCliente.listar();
		System.out.println("Listagem de clientes");
		for (Cliente cliente : listaCliente) {
			System.out.println(cliente.getNome()+ " - "+ cliente.getId());
		}
		
		//2.Obter todos os pacotes que possuem um transporte específico;
		//Ex 02 a aula06
		System.out.println("obter pacote q possuem um transp especifico");
	    listar=dao.buscarPorTransporteEspecifico(1);
	    for(Pacote pacote: listar){
	    	System.out.println(pacote.getId()+ " - "+ pacote.getTransporte().getEmpresa());
	    }
	    
	    //3.Obter todos clientes localizados no estado de SP;
	    //Fiz buscar clientes pelo estado
	    //Ex03 da apostila 06
	    System.out.println("Clientes do estado que você digitou");
	    listaCliente= daoCliente.listarClientesPorEstado(JOptionPane.showInputDialog("Digite o estado"));
	    for (Cliente cliente : listaCliente) {
			System.out.println(cliente.getNome()+" - "+cliente.getEndereco().getCidade().getUf());
		}
		em.close();
		System.exit(0);
	}
	


}

package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

public class Exercicio04 {
	//os outros exercicios estao no console view
	

	public static void main(String[] args) {
		int dias;
		EntityManager em= EntityManagerFactorySingleton.getInstance().createEntityManager();
	
		ClienteDAO dao = new ClienteDAOImpl(em);
		dias=Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de dias"));
		
		List<Cliente>lista = dao.buscarPorDiasReserva(dias);

		for (Cliente cliente : lista) {
			System.out.println(cliente.getNome());
		}
		
		em.close();
		System.exit(0);
	}
}

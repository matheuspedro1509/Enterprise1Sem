package br.com.fiap.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemPedidoDAO;
import br.com.fiap.dao.impl.ItemPedidoDAOImpl;
import br.com.fiap.entity.ItemPedido;
import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.Produto;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Cadastra a galera
		EntityManager em= EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ItemPedidoDAO dao= new ItemPedidoDAOImpl(em);
		
		Produto prod= new Produto("Mac","nb");
		Pedido pedido= new Pedido(Calendar.getInstance(),
				Calendar.getInstance(),"Maiara");
		
		ItemPedido item = new ItemPedido(pedido,prod,10,6);
		
		try {
			dao.cadastrar(item);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}
		em.close();
		System.exit(0);
	}
}

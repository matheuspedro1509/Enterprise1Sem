package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.dao.impl.ContaDAOImpl;
import br.com.fiap.entity.Agencia;
import br.com.fiap.entity.ContaCorrente;
import br.com.fiap.entity.ContaPoupanca;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ContaDAO dao = new ContaDAOImpl(em);
		
		Agencia agencia= new Agencia();
		agencia.setEndereco("Av jardim tamoio");
		
		ContaCorrente cc = new ContaCorrente(agencia,1000,20,2000);
		ContaPoupanca cp= new ContaPoupanca(agencia,20,0.05);
		
		try{
			dao.cadastrar(cp);
			dao.cadastrar(cc);
			dao.salvar();
		}catch (DBException e) {
			e.printStackTrace();
		}
		
		em.close();
		System.exit(0);
	}
}

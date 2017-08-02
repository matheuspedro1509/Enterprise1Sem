package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.dao.impl.PessoaDAOImpl;
import br.com.fiap.entity.PessoaFisica;
import br.com.fiap.entity.PessoaJuridica;
import br.com.fiap.entity.Sexo;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		PessoaDAO dao = new PessoaDAOImpl(em);
		
		PessoaFisica pf= new PessoaFisica("Matheus","Rua jardim voce sabe o resto",
											458964460,Sexo.MASCULINO);
		
		PessoaJuridica pj= new PessoaJuridica("Resource",
				"Cenesp",12347745,"Nao sei");
		
		try{
			dao.cadastrar(pj);
			dao.cadastrar(pf);
			dao.salvar();
		}catch (DBException e) {
			e.printStackTrace();
		}
		em.close();
		System.exit(0);
	}
}

package br.com.fiap.view;

<<<<<<< HEAD
;

public class TesteDatas {

	
=======
import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;

public class TesteDatas {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PacoteDAO dao = new PacoteDAOImpl(em);
		
		
	}
>>>>>>> d6125c80b3f38ab5599ed75a31fa62e67af91abd
}

package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Livro;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		LivroDAO dao = new LivroDAOImpl(em);
		
		Editora editora = new Editora("Rocco",null);
		Autor autor = new Autor("J. K. Rowling",
								new GregorianCalendar(31,8,1965),null);
		
		List<Autor>autores = new ArrayList<>();
		autores.add(autor);
		
		Livro livro = new Livro("1545888","Harry Potter a pedra filosofal",null,editora,autores);
		
		try {
			dao.cadastrar(livro);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}
		
		em.close();
		System.exit(0);
	}
}

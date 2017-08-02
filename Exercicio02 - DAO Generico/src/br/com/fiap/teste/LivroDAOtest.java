package br.com.fiap.teste;



import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Livro;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class LivroDAOtest {

	@Test
	public void cadastrarTest() {
	
		EntityManager em= EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		LivroDAO dao= new LivroDAOImpl(em);
		Livro livro = new Livro();
		livro.setIsbn(1);
		livro.setTitulo("Jobs");
		livro.setPreco(40);
		livro.setDtLancamento(new GregorianCalendar(12,Calendar.JULY,1989));
		try{
			dao.cadastrar(livro);
			dao.salvar();
			Assert.assertNotEquals(livro.getTitulo(),0);
		}catch(DBException e){
			e.printStackTrace();
			Assert.fail();
		}finally{
			em.close();
		}
	}
	
	@Test
	public void pesquisaTest(){
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		LivroDAO dao = new LivroDAOImpl(em);
		
		Livro livro = new Livro();
		livro.setIsbn(2);
		livro.setTitulo("Cascao");
		try{
			dao.cadastrar(livro);
			dao.salvar();
		}catch(DBException e){
		e.printStackTrace();
		Assert.fail();
		}
		Livro pesquisa = dao.pesquisar(livro.getIsbn());
		Assert.assertNotNull(pesquisa);
		em.close();
	}
	
	@Test
	public void removeTest(){
		EntityManager em = EntityManagerFactorySingleton.
				getInstance().createEntityManager();
		LivroDAO dao = new LivroDAOImpl(em);
		
		Livro livro = new Livro();
		livro.setIsbn(3);
		livro.setTitulo("Fiap");
		
		try{
			dao.cadastrar(livro);
			dao.salvar();
			
			dao.remover(livro.getIsbn());
			dao.salvar();
			
			Livro busca = dao.pesquisar(livro.getIsbn());
			Assert.assertNull(busca);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Test 
	public void atualizaTest(){
		EntityManager em = EntityManagerFactorySingleton.
				getInstance().createEntityManager();
		
		LivroDAO dao = new LivroDAOImpl(em);
		
		Livro livro = new Livro();
		livro.setIsbn(4);
		livro.setTitulo("Tecnologia");
		
		try{
			dao.cadastrar(livro);
			dao.salvar();
			
			livro.setTitulo("Cloud");
			livro.setIsbn(5);
			
			dao.alterar(livro);
			dao.salvar();
			
			Livro busca = dao.pesquisar(livro.getIsbn());
			Assert.assertEquals(busca.getTitulo(), livro.getTitulo());
			Assert.assertEquals(busca.getIsbn(), 5);
			
		}catch(DBException e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	}
}

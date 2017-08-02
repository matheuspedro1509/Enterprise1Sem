package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.fiap.dao.EmprestimoDAO;
import br.com.fiap.dao.impl.EmprestimoDAOImpl;
import br.com.fiap.entity.Emprestimo;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class EmprestimoDAOTest {

	@Test
	public void cadastrarTest() {
	
		EntityManager em= EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		EmprestimoDAO dao= new EmprestimoDAOImpl(em);
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDtEmprestimo(new GregorianCalendar(12,Calendar.FEBRUARY,2017));
		emprestimo.setDtRetorno(new GregorianCalendar(25,Calendar.FEBRUARY,2017));
		
		try{
			dao.cadastrar(emprestimo);
			dao.salvar();
			Assert.assertNotEquals(emprestimo.getId(),0);
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
		
		EmprestimoDAO dao= new EmprestimoDAOImpl(em);
		
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDtEmprestimo(new GregorianCalendar(15,Calendar.FEBRUARY,2017));
		emprestimo.setDtRetorno(new GregorianCalendar(27,Calendar.FEBRUARY,2017));
		try{
			dao.cadastrar(emprestimo);
			dao.salvar();
		}catch(DBException e){
		e.printStackTrace();
		Assert.fail();
		}
		Emprestimo pesquisa = dao.pesquisar(emprestimo.getId());
		Assert.assertNotNull(pesquisa);
		em.close();
	}
	
	@Test
	public void removeTest(){
		EntityManager em = EntityManagerFactorySingleton.
				getInstance().createEntityManager();
		
		EmprestimoDAO dao= new EmprestimoDAOImpl(em);
		
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDtEmprestimo(new GregorianCalendar(05,Calendar.MARCH,2017));
		emprestimo.setDtRetorno(new GregorianCalendar(15,Calendar.MARCH,2017));
		
		try{
			dao.cadastrar(emprestimo);
			dao.salvar();
			
			dao.remover(emprestimo.getId());
			dao.salvar();
			
			Emprestimo busca = dao.pesquisar(emprestimo.getId());
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

		EmprestimoDAO dao= new EmprestimoDAOImpl(em);
		
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDtEmprestimo(new GregorianCalendar(07,Calendar.MARCH,2017));
		emprestimo.setDtRetorno(new GregorianCalendar(15,Calendar.MARCH,2017));
		
		
		try{
			dao.cadastrar(emprestimo);
			dao.salvar();
			
			emprestimo.setDtEmprestimo(new GregorianCalendar(10,Calendar.MARCH,2017));
			emprestimo.setDtRetorno(new GregorianCalendar(16,Calendar.MARCH,2017));
			
			dao.alterar(emprestimo);
			dao.salvar();
			
			Emprestimo busca = dao.pesquisar(emprestimo.getId());
			Assert.assertEquals(busca.getDtEmprestimo(),emprestimo.getDtEmprestimo());
			Assert.assertEquals(busca.getDtRetorno(),emprestimo.getDtRetorno());
			
		}catch(DBException e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	}

}

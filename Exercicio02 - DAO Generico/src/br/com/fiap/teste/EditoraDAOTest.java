package br.com.fiap.teste;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.fiap.dao.EditoraDAO;
import br.com.fiap.dao.impl.EditoraDAOImpl;
import br.com.fiap.entity.Editora;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class EditoraDAOTest {

	@Test
	public void cadastrarTest() {
	
		EntityManager em= EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		EditoraDAO dao= new EditoraDAOImpl(em);
		
		Editora editora = new Editora();
		editora.setCnpj("12345678910");
		editora.setNome("Intriseca");
		
		try{
			dao.cadastrar(editora);
			dao.salvar();
			Assert.assertNotEquals(editora.getId(),0);
		}catch(DBException e){
			e.printStackTrace();
			Assert.fail();
		}finally{
			em.close();
		}
	}
	
	@Test
	public void pesquisaTest() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		EditoraDAO dao= new EditoraDAOImpl(em);
		
		Editora editora = new Editora();
		editora.setCnpj("76382037493");
		editora.setNome("Moderna");
		
		try{
			dao.cadastrar(editora);
			dao.salvar();
		}catch(DBException e){
		e.printStackTrace();
		Assert.fail();
		}
		Editora pesquisa = dao.pesquisar(editora.getId());
		Assert.assertNotNull(pesquisa);
		em.close();
	}
	
	@Test
	public void removeTest(){
		EntityManager em = EntityManagerFactorySingleton.
				getInstance().createEntityManager();
		EditoraDAO dao= new EditoraDAOImpl(em);
		
		Editora editora = new Editora();
		editora.setCnpj("829031733");
		editora.setNome("Rocco");
		
		try{
			dao.cadastrar(editora);
			dao.salvar();
			
			dao.remover(editora.getId());
			dao.salvar();
			
			Editora busca = dao.pesquisar(editora.getId());
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
		
		EditoraDAO dao= new EditoraDAOImpl(em);
		
		Editora editora = new Editora();
		editora.setCnpj("9390012734");
		editora.setNome("Globo");
		
		try{
			dao.cadastrar(editora);
			dao.salvar();
			
			editora.setCnpj("098009");
			editora.setNome("Editora");
			
			dao.alterar(editora);
			dao.salvar();
			
			Editora busca = dao.pesquisar(editora.getId());
			Assert.assertEquals(busca.getCnpj(),editora.getCnpj());
			Assert.assertEquals(busca.getNome(),editora.getNome());
			
			
			
		}catch(DBException e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	}


}

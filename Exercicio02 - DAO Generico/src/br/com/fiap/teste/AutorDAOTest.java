package br.com.fiap.teste;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.fiap.dao.AutorDAO;
import br.com.fiap.dao.impl.AutorDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Sexo;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class AutorDAOTest {


	@Test
	public void cadastrarTest() {
	
		EntityManager em= EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		AutorDAO dao= new AutorDAOImpl(em);
		
		Autor autor = new Autor();
		autor.setNome("Mauricio");
		autor.setSobrenome("De Souza");
		autor.setSexo(Sexo.MASCULINO);
		
		try{
			dao.cadastrar(autor);
			dao.salvar();
			Assert.assertNotEquals(autor.getId(),0);
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

		AutorDAO dao = new AutorDAOImpl(em);

		Autor autor = new Autor();
		autor.setNome("Cecilia");
		autor.setSobrenome("Meireles");
		autor.setSexo(Sexo.FEMININO);
		
		try{
			dao.cadastrar(autor);
			dao.salvar();
		}catch(DBException e){
		e.printStackTrace();
		Assert.fail();
		}
		Autor pesquisa = dao.pesquisar(autor.getId());
		Assert.assertNotNull(pesquisa);
		em.close();
	}
	
	@Test
	public void removeTest(){
		EntityManager em = EntityManagerFactorySingleton.
				getInstance().createEntityManager();
	AutorDAO dao= new AutorDAOImpl(em);
		
		Autor autor = new Autor();
		autor.setNome("Machaddo");
		autor.setSobrenome("De Assis");
		autor.setSexo(Sexo.MASCULINO);
		
		try{
			dao.cadastrar(autor);
			dao.salvar();
			
			dao.remover(autor.getId());
			dao.salvar();
			
			Autor busca = dao.pesquisar(autor.getId());
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
		
		AutorDAO dao= new AutorDAOImpl(em);
		
		Autor autor = new Autor();
		autor.setNome("Fernando");
		autor.setSobrenome("Pssoa");
		autor.setSexo(Sexo.MASCULINO);
		
		try{
			dao.cadastrar(autor);
			dao.salvar();
			
			autor.setNome("Fernanda");
			autor.setSexo(Sexo.FEMININO);
			
			dao.alterar(autor);
			dao.salvar();
			
			Autor busca = dao.pesquisar(autor.getId());
			Assert.assertEquals(busca.getNome(),autor.getNome());
			Assert.assertEquals(busca.getSexo(),autor.getSexo());
			
			
		}catch(DBException e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	}

}

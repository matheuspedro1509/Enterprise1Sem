package br.com.fiap.teste;



import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.fiap.dao.ServicoDAO;
import br.com.fiap.dao.impl.ServicoDAOImpl;
import br.com.fiap.entity.Servico;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class GenericDAOTest {

	@Test
	public void cadastroTest() {
		//chama o entityManager
		
		EntityManager em = EntityManagerFactorySingleton.
				getInstance().createEntityManager();
		
		//instancia o objeto
		ServicoDAO dao = new ServicoDAOImpl(em);
		Servico servico = new Servico();
		servico.setNome("Banho");
		servico.setPreco(40);
		
		try{
			//chamar o serviço/cadastrar
			dao.cadastrar(servico);
			dao.salvar();
			
			//testar o resultado
			Assert.assertNotEquals(servico.getCodigo(),0);
		} catch (DBException e) {
			e.printStackTrace();
			Assert.fail();
		}finally{
			em.close();
		}

	}
	
	@Test
	public void buscaTest(){
		//chama o entityManager
		EntityManager em = EntityManagerFactorySingleton.
				getInstance().createEntityManager();
		
		//Instanciar o servicoDAO
		ServicoDAO dao = new ServicoDAOImpl(em);
		
		
		Servico servico= new Servico();
		servico.setNome("Tosa");
		servico.setPreco(35);
		try {
			//Cadastrar o servico
			dao.cadastrar(servico);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		
		//Chma o método busca do dao
		Servico busca= dao.pesquisar(servico.getCodigo());
		
		//Valida se encontrou o servico no banco
		Assert.assertNotNull(busca);
		
		em.close();
	}
	
	@Test
	public void removeTest(){
		
		EntityManager em = EntityManagerFactorySingleton.
				getInstance().createEntityManager();
		
		ServicoDAO dao = new ServicoDAOImpl(em);
		
		Servico servico= new Servico();
		servico.setNome("Nois");
		servico.setPreco(84);
		try {
			//cadastrar um servico
			dao.cadastrar(servico);
			dao.salvar();
			
			//remover um servico
			dao.remover(servico.getCodigo());
			dao.salvar();
			
			//testar o resultado
			Servico busca = dao.pesquisar(servico.getCodigo());
			Assert.assertNull(busca);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em .close();
		}
	}
	
	@Test
	public void atualizaTest(){
		// inicializa os objetos 
		EntityManager em= EntityManagerFactorySingleton.
				getInstance().createEntityManager();
		ServicoDAO dao = new ServicoDAOImpl(em);
		
		Servico servico = new Servico();
		servico.setNome("Hospedagem Comum");
		servico.setPreco(49);
		
		try {
			//cadastra o servico
			dao.cadastrar(servico);
			dao.salvar();
			
			servico.setPreco(80);
			servico.setNome("Hospedagem comum mais cara");
			
			dao.alterar(servico);
			dao.salvar();
			
			Servico busca = dao.pesquisar(servico.getCodigo());
			Assert.assertEquals(busca.getPreco(),80,0);
			Assert.assertEquals(busca.getNome(),servico.getNome());
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	}

}

package br.com.fiap.teste;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.fiap.dao.ExemplarDAO;
import br.com.fiap.dao.impl.ExemplarDAOImpl;
import br.com.fiap.entity.Exemplar;
import br.com.fiap.entity.Situacao;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ExemplarDAOTest {

	@Test
	public void cadastrarTest() {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ExemplarDAO dao = new ExemplarDAOImpl(em);

		Exemplar exemplar = new Exemplar();

		exemplar.setSituacao(Situacao.DISPONIVEL);

		try {
			dao.cadastrar(exemplar);
			dao.salvar();
			Assert.assertNotEquals(exemplar.getId(), 0);
		} catch (DBException e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			em.close();
		}
	}

	@Test
	public void pesquisaTest() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ExemplarDAO dao = new ExemplarDAOImpl(em);

		Exemplar exemplar = new Exemplar();
		exemplar.setSituacao(Situacao.EMPRESTADO);
		try {
			dao.cadastrar(exemplar);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			Assert.fail();
		}
		Exemplar pesquisa = dao.pesquisar(exemplar.getId());
		Assert.assertNotNull(pesquisa);
		em.close();
	}

	@Test
	public void removeTest() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ExemplarDAO dao = new ExemplarDAOImpl(em);

		Exemplar exemplar = new Exemplar();
		exemplar.setSituacao(Situacao.MANUTENCAO);
		try {
			dao.cadastrar(exemplar);
			dao.salvar();

			dao.remover(exemplar.getId());
			dao.salvar();

			Exemplar busca = dao.pesquisar(exemplar.getId());
			Assert.assertNull(busca);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Test
	public void atualizaTest() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ExemplarDAO dao = new ExemplarDAOImpl(em);

		Exemplar exemplar = new Exemplar();
		exemplar.setSituacao(Situacao.DISPONIVEL);

		try {
			dao.cadastrar(exemplar);
			dao.salvar();

			exemplar.setSituacao(Situacao.EMPRESTADO);

			dao.alterar(exemplar);
			dao.salvar();

			Exemplar busca = dao.pesquisar(exemplar.getId());
			Assert.assertEquals(busca.getSituacao(),exemplar.getSituacao());
	

		} catch (DBException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}

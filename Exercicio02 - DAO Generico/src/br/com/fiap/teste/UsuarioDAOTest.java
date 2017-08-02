package br.com.fiap.teste;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.impl.UsuarioDAOImpl;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class UsuarioDAOTest {

	@Test
	public void cadastrarTest() {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		UsuarioDAO dao = new UsuarioDAOImpl(em);

		Usuario usuario = new Usuario();

		usuario.setUsuario("matheus15");
		usuario.setNome("Matheus");
		usuario.setCpf("8830283023");

		try {
			dao.cadastrar(usuario);
			dao.salvar();
			Assert.assertNotEquals(usuario.getId(), 0);
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

		UsuarioDAO dao = new UsuarioDAOImpl(em);

		Usuario usuario = new Usuario();
		usuario.setUsuario("jobs83");
		usuario.setNome("Steve");
		usuario.setCpf("23844983");
		try {
			dao.cadastrar(usuario);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			Assert.fail();
		}
		Usuario pesquisa = dao.pesquisar(usuario.getId());
		Assert.assertNotNull(pesquisa);
		em.close();
	}

	@Test
	public void removeTest() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		UsuarioDAO dao = new UsuarioDAOImpl(em);

		Usuario usuario = new Usuario();
		usuario.setUsuario("math16");
		usuario.setNome("Matheus S");
		usuario.setCpf("35i37983648");
		try {
			dao.cadastrar(usuario);
			dao.salvar();

			dao.remover(usuario.getId());
			dao.salvar();

			Usuario busca = dao.pesquisar(usuario.getId());
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

		UsuarioDAO dao = new UsuarioDAOImpl(em);

		Usuario usuario = new Usuario();
		usuario.setUsuario("Jose9");
		usuario.setNome("Jose S");
		usuario.setCpf("9274649023");
		try {
			dao.cadastrar(usuario);
			dao.salvar();

			usuario.setUsuario("Ma10");
			usuario.setNome("Maria");
			usuario.setCpf("308430284");

			dao.alterar(usuario);
			dao.salvar();

			Usuario busca = dao.pesquisar(usuario.getId());
			Assert.assertEquals(busca.getCpf(),usuario.getCpf());
			Assert.assertEquals(busca.getUsuario(),usuario.getUsuario());
			Assert.assertEquals(busca.getNome(),usuario.getNome());

		} catch (DBException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	

}

package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	//.class da entidade (usado na busca)
	private Class<T> classe;
	
	//Construtor
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		classe = (Class<T>) ((ParameterizedType)getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entity) throws DBException {
		try{
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar",e);
		}
	}

	@Override
	public void alterar(T entity) throws DBException {
		try{
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new DBException("Erro ao atualizar",e);
		}
		
	}

	@Override
	public void remover(K codigo) throws DBException {
		try{
			em.getTransaction().begin();
			em.remove(pesquisar(codigo));
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new DBException("Erro ao remover",e);
		}
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(classe, codigo);
	}

}

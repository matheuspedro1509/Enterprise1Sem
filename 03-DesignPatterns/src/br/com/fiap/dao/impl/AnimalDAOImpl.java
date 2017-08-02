package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AnimalDAO;
import br.com.fiap.entity.Animal;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class AnimalDAOImpl implements AnimalDAO {

	EntityManager em = EntityManagerFactorySingleton
						.getInstance().createEntityManager();
	
	@Override
	public void cadastrar(Animal animal) throws DBException {
		//Tratar as exceções...
		try{
			em.getTransaction().begin();
			em.persist(animal);
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new DBException("Erro ao persistir",e);
		}
	}

	@Override
	public Animal pesquisar(int codigo) {
		return em.find(Animal.class, codigo); 
	}

	@Override
	public void alterar(Animal animal) throws DBException {
		try{
			em.getTransaction().begin();
			em.merge(animal);
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new DBException("Erro ao persistir",e);
		}
	}

	@Override
	public void remover(int codigo) throws DBException {
		try{
			em.getTransaction().begin();		
			em.remove(pesquisar(codigo));
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new DBException("Erro ao persistir",e);
		}
	}
}
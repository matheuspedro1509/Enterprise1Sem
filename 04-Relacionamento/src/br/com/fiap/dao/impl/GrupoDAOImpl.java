package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.entity.GrupoAm;

public class GrupoDAOImpl extends GenericDAOImpl <GrupoAm, Integer> implements GrupoAmDAO {

	public GrupoDAOImpl(EntityManager em) {
		super(em);
		
	}

}

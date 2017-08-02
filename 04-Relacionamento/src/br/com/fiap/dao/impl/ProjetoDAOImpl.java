package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.entity.ProjetoAm;

public class ProjetoDAOImpl extends GenericDAOImpl<ProjetoAm,Integer> implements ProjetoAmDAO{

	public ProjetoDAOImpl(EntityManager em) {
		super(em);
		
	}
}

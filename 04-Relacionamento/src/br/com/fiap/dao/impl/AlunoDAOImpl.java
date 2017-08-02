package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoAmDao;
import br.com.fiap.entity.AlunoAm;

public class AlunoDAOImpl extends GenericDAOImpl<AlunoAm,Integer> implements AlunoAmDao{

	public AlunoDAOImpl(EntityManager em) {
		super(em);
	}

}

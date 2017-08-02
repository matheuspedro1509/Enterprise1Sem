package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProfessorAmDAO;
import br.com.fiap.entity.ProfessorAm;


public class ProfessorDAOImpl extends GenericDAOImpl<ProfessorAm,Integer> implements ProfessorAmDAO {

	public ProfessorDAOImpl(EntityManager em) {
		super(em);
	}

}

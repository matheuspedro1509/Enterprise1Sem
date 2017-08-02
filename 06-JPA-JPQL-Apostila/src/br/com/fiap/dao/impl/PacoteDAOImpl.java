package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> listar() {
		TypedQuery<Pacote> query= 
				em.createQuery("from Pacote",Pacote.class);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorQuantidadeDiasMinimo(int dias) {
		TypedQuery<Pacote> query=//Nome da classe e do atributo
				em.createQuery("from Pacote p where p.qtdDias >= :churros",Pacote.class);
		query.setParameter("churros", dias);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorTransporteEspecifico(int id) {
		TypedQuery<Pacote> query=
				em.createQuery("from Pacote p where p.transporte.id = :transporte",Pacote.class);
		query.setParameter("transporte", id);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		TypedQuery<Pacote> query = 
				em.createQuery("from Pacote p where p.dataSaida between :inicio and :fim",Pacote.class);
		query.setParameter("inicio", inicio);
		query.setParameter("fim",fim);
		
		return query.getResultList();
	}

}

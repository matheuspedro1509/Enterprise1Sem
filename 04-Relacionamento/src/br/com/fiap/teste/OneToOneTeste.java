package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.dao.impl.GrupoDAOImpl;
import br.com.fiap.dao.impl.ProjetoDAOImpl;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class OneToOneTeste {

	public static void main(String[] args) {
		EntityManager em= EntityManagerFactorySingleton.getInstance().createEntityManager();

		GrupoAmDAO grupoDao = new GrupoDAOImpl(em);
		ProjetoAmDAO projetoDao = new ProjetoDAOImpl(em);
		
		GrupoAm grupo = new GrupoAm(0,"BarraGall");
		
		ProjetoAm projeto = new ProjetoAm(0,"Advocacia LCA",0,Calendar.getInstance(),
				new GregorianCalendar(2017,Calendar.OCTOBER,2),grupo,null);
		
		//grupoDao.cadastrar(grupo);
		projetoDao.cadastrar(projeto);
		try{
			grupoDao.salvar();
		}catch(DBException e){
			e.printStackTrace();
		}
		em.close();
		System.exit(0);
	}
}

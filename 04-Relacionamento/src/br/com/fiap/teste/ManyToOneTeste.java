package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;


import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoDAOImpl;
import br.com.fiap.entity.AlunoAm;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ManyToOneTeste {

	public static void main(String[] args) {
		EntityManager em= EntityManagerFactorySingleton.
				getInstance().createEntityManager();
		
		GrupoAmDAO dao= new GrupoDAOImpl(em);
		
		GrupoAm grupo= new GrupoAm(0,"Barra Code");
		AlunoAm aluno1= new AlunoAm(0,"William Burro", 
				new GregorianCalendar(1987,Calendar.APRIL,12),grupo);
		AlunoAm aluno2= new AlunoAm(0,"Matheus Santana", 
				new GregorianCalendar(1998,Calendar.SEPTEMBER,15),grupo);
		AlunoAm aluno3= new AlunoAm(0,"Vinicius", 
				new GregorianCalendar(1998,Calendar.JULY,18),grupo);
		AlunoAm aluno4= new AlunoAm(0,"Marck Zuck", 
				new GregorianCalendar(1985,Calendar.DECEMBER,25),grupo);

		/*
		 * List<AlunoAm> alunos= new ArrayList<AlunoAm>();
		alunos.add(aluno1);
		alunos.add(aluno2);
		alunos.add(aluno3);
		alunos.add(aluno4);
		
		grupo.setAlunos(alunos);
		*/
		grupo.addAluno(aluno1);
		grupo.addAluno(aluno2);
		grupo.addAluno(aluno3);
		grupo.addAluno(aluno4);
		
		
		dao.cadastrar(grupo);
		
		try {
			dao.salvar();
		} catch (DBException e) {
		   e.printStackTrace();
		}
		em.close();
		System.exit(0);
	}

}

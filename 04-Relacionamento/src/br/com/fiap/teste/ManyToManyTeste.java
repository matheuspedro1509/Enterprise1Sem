package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProfessorAmDAO;
import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.dao.impl.ProfessorDAOImpl;
import br.com.fiap.dao.impl.ProjetoDAOImpl;
import br.com.fiap.entity.AlunoAm;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.entity.ProfessorAm;
import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ManyToManyTeste {

	public static void main(String[] args) {
		//cadastrar um projeto , grupo e orientadores
		
		//obter o EntityManager
		EntityManager em= EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		//Instanciar dois grupos
		//GrupoAmDAO daoGrupo = new GrupoDAOImpl(em);
		
		GrupoAm grupo = new GrupoAm(0,"JavaNois");
		GrupoAm grupo2= new GrupoAm(0,"Pastel");
		
		AlunoAm aluno1= new AlunoAm(0,"Jobszinho", 
				new GregorianCalendar(1956,Calendar.APRIL,18),grupo);
		AlunoAm aluno2= new AlunoAm(0,"Gustavo", 
				new GregorianCalendar(2006,Calendar.OCTOBER,20),grupo);
		AlunoAm aluno3= new AlunoAm(0,"Rp", 
				new GregorianCalendar(2010,Calendar.NOVEMBER,8),grupo2);
		AlunoAm aluno4= new AlunoAm(0,"HMM", 
				new GregorianCalendar(1994,Calendar.MARCH,30),grupo2);
		
		grupo.addAluno(aluno1);
		grupo.addAluno(aluno2);
		grupo.addAluno(aluno3);
		grupo.addAluno(aluno4);
	
	
		
		//instanciar dois projetos passando o grupo
		
		ProjetoAm projeto1= new ProjetoAm(0,"Tema 1",0,Calendar.getInstance(),
				new GregorianCalendar(2017,Calendar.OCTOBER,10),grupo,null);
		ProjetoAm projeto2= new ProjetoAm(0,"Tema 2",0,Calendar.getInstance(),
				new GregorianCalendar(2017,Calendar.OCTOBER,10),grupo2,null);
		
		//instanciar dois professores
		ProfessorAm pf1 = new ProfessorAm(0,"Humberto",
				new GregorianCalendar(2014,Calendar.JANUARY,10),10000,null);
		ProfessorAm pf2 = new ProfessorAm(0,"Rita",
				new GregorianCalendar(2000,Calendar.JANUARY,17),15000,null);
				
		//relacionar o projeto com os professores
		List<ProjetoAm> projetos= new ArrayList<ProjetoAm>();
		projetos.add(projeto1);
		projetos.add(projeto2);
		
		pf1.setProjetos(projetos);
		pf2.setProjetos(projetos);
		
		//instanciar o DAO do projeto e do professor
		 ProjetoAmDAO projetoDAO = new ProjetoDAOImpl(em);
		 ProfessorAmDAO professorDAO= new ProfessorDAOImpl(em);
		 
		//cadastrar os professores
		 professorDAO.cadastrar(pf1);
		 professorDAO.cadastrar(pf2);
		
		//cadastrar os projetos
		projetoDAO.cadastrar(projeto2);
		projetoDAO.cadastrar(projeto1);
		
		 //commit
		try {
			projetoDAO.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			}
		//SUCESSO AMIGO
		em.close();
		System.exit(0);
	}


}

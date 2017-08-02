package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Campeonato;
import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Tecnico;
import br.com.fiap.entity.Time;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastraTudoTeste {

	public static void main(String[] args) {
		//obter o entity manager
		EntityManager em= EntityManagerFactorySingleton.
				getInstance().createEntityManager();
		
		//instanciar  o TimeDAOImpl
		TimeDAO dao = new TimeDAOImpl(em);
		
		//instanciar a galera(entidades)
		//criar os construtores de acordo com o que voce precisa 
		Tecnico tecnico = new Tecnico("Rita");
		Time time =new Time("2TDSA",Calendar.getInstance(),0,tecnico);
		
		time.addJogador(new Jogador("Matheus"));
		time.addJogador(new Jogador("Neymar"));
		time.addJogador(new Jogador("G Jesus"));
		
		List<Campeonato>lista = new ArrayList<Campeonato>();
		lista.add(new Campeonato("Smart World"));
		lista.add(new Campeonato("Startup One"));
		
		time.setCampeonatos(lista);
		//cadastrar o time e commit (o resto vai por cascata)
		
		try {
			dao.cadastrar(time);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	
	}
}

package br.com.fiap.dao;

import br.com.fiap.entity.Animal;
import br.com.fiap.exception.DBException;

public interface AnimalDAO {

	void cadastrar(Animal animal) throws DBException;
	Animal pesquisar(int codigo);
	void alterar(Animal animal) throws DBException;
	void remover(int codigo) throws DBException;
	
}
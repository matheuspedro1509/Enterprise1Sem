package br.com.fiap.dao;

import br.com.fiap.exception.DBException;

public interface GenericDAO<T,K> {

	void cadastrar(T entity) throws DBException;
	void alterar(T entity) throws DBException;
	void remover(K codigo) throws DBException;
	T pesquisar(K codigo);
	
}

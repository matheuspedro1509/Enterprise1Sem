package br.com.fiap.dao;

import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

public interface GenericDAO<T,K> {
	void cadastrar (T entity);
	T pesquisar(K codigo);
	void remover(K codigo) throws IdNotFoundException;
	void alterar(T entity);
	void salvar()throws DBException;
	

}

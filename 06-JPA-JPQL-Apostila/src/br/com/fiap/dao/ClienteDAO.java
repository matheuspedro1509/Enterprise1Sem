package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente>listar();
	List<Cliente>listarClientesPorEstado(String cidade);
	
	List<Cliente>buscarPorDiasReserva(int dias);
}

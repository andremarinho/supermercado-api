package com.supermercado.service;

import java.util.List;

import com.supermercado.domain.Cliente;
import com.supermercado.filter.ClienteFilter;

public interface ClienteService {

	public List<Cliente> findAll() throws Exception;

	public Cliente findByCodigo(Long codigo) throws Exception;

	public Cliente insert(Cliente cliente) throws Exception;

	public void delete(Long codigo) throws Exception;

	public Cliente findByCpf(String cpf);

	public Cliente update(Long codigo, Cliente cliente) throws Exception;
	
	public List<Cliente> findClienteByFilter(ClienteFilter clienteFilter);
}

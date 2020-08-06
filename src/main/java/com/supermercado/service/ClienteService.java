package com.supermercado.service;

import java.util.List;

import com.supermercado.domain.Cliente;

public interface ClienteService {

	
	public List<Cliente> findAll();
	
	public Cliente insert(Cliente cliente);
}

package com.supermercado.repository;

import java.util.List;

import com.supermercado.domain.Cliente;
import com.supermercado.filter.ClienteFilter;

public interface CustomClienteRepository {
	
	public List<Cliente> getClienteFilter(ClienteFilter clienteFilter);
	
}

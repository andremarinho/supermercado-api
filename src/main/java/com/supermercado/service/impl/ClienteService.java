package com.supermercado.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermercado.domain.Cliente;
import com.supermercado.repository.ClienteRepository;


@Service
public class ClienteService implements com.supermercado.service.ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
	
	
	public Cliente insert(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

}

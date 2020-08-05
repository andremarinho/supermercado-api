package com.supermercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermercado.domain.Cliente;
import com.supermercado.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
	
	
	public Cliente insert(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

}

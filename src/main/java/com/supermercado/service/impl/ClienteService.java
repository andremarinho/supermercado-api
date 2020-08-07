package com.supermercado.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.naming.NoPermissionException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.supermercado.domain.Cliente;
import com.supermercado.domain.Telefone;
import com.supermercado.filter.ClienteFilter;
import com.supermercado.repository.ClienteRepository;


@Service
public class ClienteService implements com.supermercado.service.ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public List<Cliente> findAll() {
		List<Cliente> clientes =  this.clienteRepository.findAll();
		return clientes;
	}
	
	
	public Cliente insert(Cliente cliente) throws Exception {
		
		validateIfCpfExists(cliente);
		validateTelefoneRepeated(cliente);
		return this.clienteRepository.save(cliente);
	}


	@Override
	public Cliente findByCpf(String cpf) {
		return this.clienteRepository.findByCpf(cpf);
	}
	
	
		
	
	
	public void validateIfCpfExists(Cliente cliente) throws Exception  {
		
		Cliente clienteEncontrado = findByCpf(cliente.getCpf());
		
		if(clienteEncontrado != null) {
			throw new Exception("Não é possivel incluir pois o cpf já esta cadastrado");
		}
	}
	
	public void validateTelefoneRepeated(Cliente cliente) throws Exception {
			
		
		if(cliente.getTelefones() != null) {
				List<Telefone> telefones =  cliente.getTelefones();
											
				List<String> telefonesRepetidos = new ArrayList<>();
				telefones.stream()
							.filter(n -> Collections.frequency(telefones, n) > 1)
							.distinct()
							.forEach(e -> telefonesRepetidos.add(e.getTelefone()));
				
				if(telefonesRepetidos.size() > 0) {
					throw new Exception("Telefone repetidos");
				}
		}
		
	}


	@Override
	public Cliente findByCodigo(Long codigo) throws Exception {
		Cliente clienteSalvo = this.clienteRepository.findByCodigo(codigo);
		
		if(clienteSalvo != null) {
			return clienteSalvo;
		}else {
			throw new Exception("Cliente não encontrado no banco de dados");
		}
		
	}


	@Override
	public void delete(Long codigo) throws Exception {
		Cliente cliente = findByCodigo(codigo);
		
		if(cliente != null) {
			this.clienteRepository.delete(cliente);
		}else {
			throw new Exception("Cliente não encontrado no banco de dados.");
		}
		
		
	}


	@Override
	public Cliente update(Long codigo, Cliente cliente) throws Exception {
		
		
		Cliente clienteSalvo;
		clienteSalvo = findByCodigo(codigo);
		BeanUtils.copyProperties(cliente, clienteSalvo, "codigo");
		return this.clienteRepository.save(clienteSalvo);
			
		
		
	}


	@Override
	public List<Cliente> findClienteByFilter(ClienteFilter clienteFilter) {
		
		return this.clienteRepository.getClienteFilter(clienteFilter);
	}
	
	

}

package com.supermercado.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.supermercado.domain.Cliente;
import com.supermercado.domain.Telefone;

public interface ClienteRepository extends MongoRepository<Cliente, Long>, CustomClienteRepository {
	
	public Cliente findByCodigo(Long codigo);
	
	public Cliente  findByCpf(String cpf);
	 
	public List<Telefone> findByTelefonesIn(List<Telefone> telefones);

}

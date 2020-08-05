package com.supermercado.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.supermercado.domain.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, Integer> {

}

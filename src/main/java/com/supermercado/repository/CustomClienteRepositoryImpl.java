package com.supermercado.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import com.supermercado.domain.Cliente;
import com.supermercado.filter.ClienteFilter;

public class CustomClienteRepositoryImpl implements CustomClienteRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<Cliente> getClienteFilter(ClienteFilter clienteFilter) {
		
		Query query = new Query();
		
		if(clienteFilter.getCodigo() != null) {
			Criteria codigo = Criteria.where("codigo").is(clienteFilter.getCodigo());
		   	query.addCriteria(codigo);
		}
		if(StringUtils.hasLength(clienteFilter.getNome())) {
			Criteria nome = Criteria.where("nome").regex(clienteFilter.getNome(), "i");
			query.addCriteria(nome);
		}
		if(StringUtils.hasLength(clienteFilter.getCpf())) {
			Criteria cpf = Criteria.where("cpf").is(clienteFilter.getCpf());
			query.addCriteria(cpf);
		}
		if (clienteFilter.getDataInicial() != null && clienteFilter.getDatafinal() != null){
			Criteria dataInicial = Criteria.where("dataNascimento")
									.gte(clienteFilter.getDataInicial())
									.and("dataNascimento")
									.lte(clienteFilter.getDatafinal());
			query.addCriteria(dataInicial);
		}else if (clienteFilter.getDataInicial() != null){
			Criteria dataInicial = Criteria.where("dataNascimento").is(clienteFilter.getDataInicial());
			query.addCriteria(dataInicial);
		}
		
		if(clienteFilter.getSexo() != null) {
			Criteria sexo = Criteria.where("sexo").is(clienteFilter.getSexo().toString());
			query.addCriteria(sexo);
		}
		
		if(clienteFilter.getSituacao() != null) {
			Criteria situacao = Criteria.where("situacao").is(clienteFilter.getSituacao().toString());
			query.addCriteria(situacao);
		}
		return mongoTemplate.find(query, Cliente.class);
	}
	
	
}

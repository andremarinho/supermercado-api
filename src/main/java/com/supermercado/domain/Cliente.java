package com.supermercado.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document
public class Cliente {

	@Id
	private Integer codigo;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private List<Telefone> telefones;
	
	
}

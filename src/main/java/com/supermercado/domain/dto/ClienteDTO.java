package com.supermercado.domain.dto;

import java.io.Serializable;

import com.supermercado.domain.Cliente;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	
	public ClienteDTO(Cliente cliente) {
		this.codigo = cliente.getCodigo();
		this.nome = cliente.getNome();
	}

}

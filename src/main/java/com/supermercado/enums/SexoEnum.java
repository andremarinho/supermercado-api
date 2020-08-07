package com.supermercado.enums;

public enum SexoEnum {

	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String descricao;
	
	private SexoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}

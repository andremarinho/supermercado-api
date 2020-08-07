package com.supermercado.enums;

public enum SituacaoEnum {

	ATIVO("Ativo"), 
	INATIVO("Inativo");

	private String descricao;

	private SituacaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}

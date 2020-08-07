package com.supermercado.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;


import com.supermercado.enums.SexoEnum;
import com.supermercado.enums.SituacaoEnum;


@Validated
@Document
public  class Cliente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Transient
    public static final String SEQUENCE_NAME = "clientes_sequence";
	
	@Id
	private Long codigo;
	@NotNull
	private String nome;
	@NotNull
	private String cpf;
	private LocalDate dataNascimento;
	private List<Telefone> telefones;
	private SituacaoEnum situacao;
	private SexoEnum sexo;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public SituacaoEnum getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	public SexoEnum getSexo() {
		return sexo;
	}
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	
	
	
}

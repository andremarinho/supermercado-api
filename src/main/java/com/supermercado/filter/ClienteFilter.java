package com.supermercado.filter;

import java.time.LocalDate;

import com.supermercado.enums.SexoEnum;
import com.supermercado.enums.SituacaoEnum;

public class ClienteFilter {

	private Long codigo;
	private String nome;
	private String cpf;
	private LocalDate dataInicial;
	private LocalDate datafinal;
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
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDatafinal() {
		return datafinal;
	}
	public void setDatafinal(LocalDate datafinal) {
		this.datafinal = datafinal;
	}
	public SituacaoEnum getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}
	public SexoEnum getSexo() {
		return sexo;
	}
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
	
	
}

package com.supermercado.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Telefone implements Serializable {
	
		
	private static final long serialVersionUID = 1L;
	
	
	private String telefone;


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Telefone(String telefone) {
		super();
		this.telefone = telefone;
	}
	
	
	
	@Override
	public String toString() {
		return this.telefone;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}


	public Telefone() {
		
	}
	
}

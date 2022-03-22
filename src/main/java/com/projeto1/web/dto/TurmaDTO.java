package com.projeto1.web.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TurmaDTO {
	
	@JsonProperty
	private String nome;	
	
	@JsonProperty
	private String sala;	

	public TurmaDTO(String nome, String sala) {
		super();
		this.nome = nome;
		this.sala = sala;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

}

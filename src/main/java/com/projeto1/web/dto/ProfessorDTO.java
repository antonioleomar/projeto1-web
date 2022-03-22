package com.projeto1.web.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProfessorDTO {
	
	@JsonProperty
	private Integer matricula;
	
	@JsonProperty	
	private String nome;	
	
	@JsonProperty
	private String formacao;
	

	public ProfessorDTO(Integer matricula, String nome, String formacao) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.formacao = formacao;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
}

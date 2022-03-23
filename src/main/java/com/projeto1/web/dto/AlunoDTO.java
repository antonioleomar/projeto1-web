package com.projeto1.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AlunoDTO {
	
	@JsonProperty
	private Long matricula;
	
	@JsonProperty
	private String nome;	
		
	public AlunoDTO() {}

	public AlunoDTO(Long matricula, String nome) {		
		this.matricula = matricula;
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

package com.projeto1.web.builder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projeto1.web.dto.AlunoDTO;

import lombok.Builder;

@Builder
public class AlunoDTOBuilder {
	
	@Builder.Default
	private Long matricula = 1L;
	
	@Builder.Default
	private String nome = "Antonio";
	
	public AlunoDTO toAlunoDTO() {
		return new AlunoDTO(matricula, nome);
	}

}

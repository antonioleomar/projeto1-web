package com.projeto1.web.builder;

import com.projeto1.web.domain.Professor;
import com.projeto1.web.dto.AlunoDTO;

import lombok.Builder;

@Builder
public class ProfessorBuilder {
	
	@Builder.Default
	private Integer matricula = 1;
	
	@Builder.Default
	private String nome = "Antonio";
	
	@Builder.Default
	private String formacao = "Engenheiro Civil";
	
	@Builder.Default
	private String email = "antonio@gmail.com";
	
	public Professor toProfessor() {
		return new Professor(matricula, nome, formacao, email);
	}

}

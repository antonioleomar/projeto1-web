package com.projeto1.web.builder;

import com.projeto1.web.domain.Professor;
import com.projeto1.web.domain.Projeto;

import lombok.Builder;

@Builder
public class ProjetoBuilder {
	
	@Builder.Default
	private Long codigo = 1L;
	
	@Builder.Default
	private String nome = "Projeto 01";
	
	@Builder.Default
	private String descricao = "Projeto da disciplina de WEB";
	
	public Projeto toProjeto() {
		return new Projeto(codigo, nome, descricao);
	}

}

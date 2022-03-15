package com.projeto1.web.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "projetos")
public class Projeto {
	
	@Id
	@Column(name="codigo", unique = true)
	@JsonProperty
	private Long codigo;
	
	@Column(name = "nome")
	@JsonProperty
	private String nome;

	@Column(name = "descricao")
	@JsonProperty
	private String descricao;
	
	@OneToOne
    @JoinColumn(name = "matricula_professor") 
	@JsonProperty
    private Professor professor;
	
	@OneToMany(mappedBy = "projeto")	
	private List<Aluno> alunos;	
	
	public Projeto() {}
}

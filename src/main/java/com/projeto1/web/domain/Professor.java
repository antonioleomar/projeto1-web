package com.projeto1.web.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "professores")
public class Professor {
	
	@Id
	@Column(name= "matricula", unique = true)
	@JsonProperty
	private Integer matricula;
	
	@Column(name = "nome")
	@JsonProperty
	private String nome;
	
	@Column(name = "formacao")
	@JsonProperty
	private String formacao;
	
	@Column(name = "email", unique = true)
	@JsonProperty
	private String email;
	
	@OneToMany(mappedBy = "professor")	
	private List<Turma> turmas;	
	
	@OneToOne(mappedBy = "professor")
	private Projeto projeto;

	public Professor() {}	

}

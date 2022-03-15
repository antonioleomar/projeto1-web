package com.projeto1.web.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "turma")
public class Turma {
	
	@Id
	@Column(name = "nome")
	@JsonProperty
	private String nome;
	
	@Column(name = "sala", unique = true)
	@JsonProperty
	private String sala;
	
	@ManyToOne
    @JoinColumn(name="professor_id")
	@JsonProperty	
    private Professor professor;
	
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos;	

	public Turma() {}	

}

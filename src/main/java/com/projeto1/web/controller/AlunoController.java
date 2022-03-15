package com.projeto1.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto1.web.domain.Aluno;
import com.projeto1.web.repository.AlunoRepository;


@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;

	@GetMapping
	public List<Aluno> getAluno(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{matricula}")
	public Optional<Aluno> getAlunoById(@PathVariable Long matricula){
		return alunoRepository.findById(matricula);
	}
	
	@PostMapping 
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@PutMapping("/{matricula}")
	public Aluno updateAluno(@PathVariable("matricula")Long matricula, @RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@DeleteMapping("/{matricula}")
	public void deleteAluno(@PathVariable Long matricula) {
		alunoRepository.delete(alunoRepository.findById(matricula).get());
	}

}

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

import com.projeto1.web.domain.Professor;
import com.projeto1.web.mapper.AlunoMapper;
import com.projeto1.web.mapper.ProfessorMapper;
import com.projeto1.web.repository.ProfessorRepository;
import com.projeto1.web.services.ProfessorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/professor")
@Api(value = "Professor Controller")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os professores")
	public List<Professor> getProfessor(){
		return professorService.getProfessor();
	}
	
	@GetMapping("/{matricula}")
	@ApiOperation(value = "Lista professor por ID")
	public Optional<Professor> getProfessorById(@PathVariable Integer matricula){
		return professorService.getProfessorById(matricula);
	}
	
	@PostMapping
	@ApiOperation(value = "criando um professor")
	public Professor createProfessor(@RequestBody Professor professor) {
		return professorService.createProfessor(professor);
	}
	
	@PutMapping("/{matricula}")	
	@ApiOperation(value = "Put de um professor")
	public Professor updateProfessor(@PathVariable("matricula") Integer matricula, @RequestBody Professor professor) {
		return professorService.updateProfessor(matricula, professor);
	}
	
	@DeleteMapping("/{matricula}")
	@ApiOperation(value = "Deletar um professor por matricula")
	public void deleteProfessor(@PathVariable Integer matricula) {
		professorService.deleteProfessor(matricula);
	}

}

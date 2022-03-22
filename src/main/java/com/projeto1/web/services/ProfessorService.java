package com.projeto1.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.projeto1.web.domain.Professor;
import com.projeto1.web.repository.ProfessorRepository;

import io.swagger.annotations.ApiOperation;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	@ApiOperation(value = "Lista todos os professores")
	public List<Professor> getProfessor() {
		return professorRepository.findAll();
	}

	@ApiOperation(value = "Lista professor por ID")
	public Optional<Professor> getProfessorById(@PathVariable Integer matricula) {
		return professorRepository.findById(matricula);
	}

	@ApiOperation(value = "criando um professor")
	public Professor createProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}

	@ApiOperation(value = "Put de um professor")
	public Professor updateProfessor(@PathVariable("matricula") Integer matricula, @RequestBody Professor professor) {
		return professorRepository.save(professor);
	}

	@ApiOperation(value = "Deletar um professor por matricula")
	public void deleteProfessor(@PathVariable Integer matricula) {
		professorRepository.delete(professorRepository.findById(matricula).get());
	}

}

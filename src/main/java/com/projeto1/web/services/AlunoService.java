package com.projeto1.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto1.web.domain.Aluno;
import com.projeto1.web.dto.AlunoDTO;
import com.projeto1.web.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;	
	
	public List<Aluno> getAluno(){
		return alunoRepository.findAll();
	}	

	public Aluno getAlunoById(@PathVariable Long matricula){
		return alunoRepository.findById(matricula).orElseThrow(() -> new RuntimeException());
	}
	
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}	

	public Aluno updateAluno(@PathVariable("matricula")Long matricula, @RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
		
	public void deleteAluno(@PathVariable Long matricula) {
		alunoRepository.delete(alunoRepository.findById(matricula).get());
	}
}

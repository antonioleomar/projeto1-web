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

import com.projeto1.web.domain.Turma;
import com.projeto1.web.repository.TurmaRepository;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping
	public List<Turma> getTurma(){
		return turmaRepository.findAll();
	}
	
	@GetMapping("/{nome}")
	public Optional<Turma> getTurmaById(@PathVariable String nome){
		return turmaRepository.findById(nome);
	}
	
	@PostMapping
	public Turma createTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}
	
	@PutMapping("/{nome}")	
	public Turma updateTurma(@PathVariable("nome") String nome, @RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}
	
	@DeleteMapping("/{nome}")
	public void deleteTurma(@PathVariable String nome) {
		turmaRepository.delete(turmaRepository.findById(nome).get());
	}

}

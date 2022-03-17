package com.projeto1.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto1.web.domain.Projeto;
import com.projeto1.web.repository.ProjetoRepository;
import com.projeto1.web.services.UsuarioAutenticado;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/projeto")
@Api(value = "Projeto Controller")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private UsuarioAutenticado usuarioAutenticado;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os projetos")
	public List<Projeto> getProjeto(){
		return projetoRepository.findAll();
	}
	
	@GetMapping("{codigo}")
	@ApiOperation(value = "Lista projetos por ID")
	public Optional<Projeto> getProjetoById(@PathVariable Long codigo){		
		return projetoRepository.findById(codigo);
	}
	
	@GetMapping("/team/{codigo}")
	@ApiOperation(value = "Lista projetos por ID")
	public List<Projeto> findByTeam(@PathVariable Long codigo){		
		return projetoRepository.findByTeam(codigo);
	}
	
	@PostMapping
	@ApiOperation(value = "criando um projeto")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public Projeto createProjeto(@RequestBody Projeto projeto) {	
		return projetoRepository.save(projeto);
	}
	
	@PutMapping("/{codigo}")	
	@ApiOperation(value = "Put de um projeto")
	public Projeto updateProjeto(@PathVariable("codigo") Long codigo, @RequestBody Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	
	@DeleteMapping("/{codigo}")
	@ApiOperation(value = "Deletar um projeto por código")
	public void deleteProjeto(@PathVariable Long codigo) {
		projetoRepository.delete(projetoRepository.findById(codigo).get());
	}

}

package com.projeto1.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.projeto1.web.domain.Projeto;
import com.projeto1.web.repository.ProjetoRepository;

import io.swagger.annotations.ApiOperation;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	@ApiOperation(value = "Lista todos os projetos")
	public List<Projeto> getProjeto() {
		return projetoRepository.findAll();
	}

	@ApiOperation(value = "Lista projetos por ID")
	public Optional<Projeto> getProjetoById(@PathVariable Long codigo) {
		return projetoRepository.findById(codigo);
	}

	@ApiOperation(value = "Lista projetos por ID")
	public List<Projeto> findByTeam(@PathVariable Long codigo) {
		return projetoRepository.findByTeam(codigo);
	}

	@ApiOperation(value = "criando um projeto")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public Projeto createProjeto(@RequestBody Projeto projeto) {
		return projetoRepository.save(projeto);
	}

	@ApiOperation(value = "Put de um projeto")
	public Projeto updateProjeto(@PathVariable("codigo") Long codigo, @RequestBody Projeto projeto) {
		return projetoRepository.save(projeto);
	}

	@ApiOperation(value = "Deletar um projeto por código")
	public void deleteProjeto(@PathVariable Long codigo) {
		projetoRepository.delete(projetoRepository.findById(codigo).get());
	}

}

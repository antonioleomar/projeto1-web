package com.projeto1.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto1.web.domain.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}

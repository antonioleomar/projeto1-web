package com.projeto1.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto1.web.domain.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
	
	@Query(value = "SELECT professores.nome, alunos.nome "
			+ "FROM PROFESSORES "
			+ "INNER JOIN PROJETOS "
			+ "ON PROFESSORES.MATRICULA = PROJETOS.MATRICULA_PROFESSOR "
			+ "INNER JOIN ALUNOS "
			+ "ON PROJETOS.CODIGO = ALUNOS.CODIGO_PROJETO "
			+ "WHERE PROJETOS.CODIGO = :codigo", nativeQuery = true)
	  List<Projeto> findByTeam(@Param("codigo") Long codigo);	
}

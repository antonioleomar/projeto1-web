package com.projeto1.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto1.web.domain.Aluno;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}

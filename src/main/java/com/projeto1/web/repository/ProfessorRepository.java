package com.projeto1.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto1.web.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}

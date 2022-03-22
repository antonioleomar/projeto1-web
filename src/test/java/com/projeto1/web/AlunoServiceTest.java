package com.projeto1.web;

import org.assertj.core.api.Assertions.*;
import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.projeto1.web.builder.AlunoDTOBuilder;
import com.projeto1.web.controller.AlunoController;
import com.projeto1.web.domain.Aluno;
import com.projeto1.web.dto.AlunoDTO;
import com.projeto1.web.mapper.AlunoMapper;
import com.projeto1.web.repository.AlunoRepository;
import com.projeto1.web.services.AlunoService;

import io.jsonwebtoken.lang.Assert;

public class AlunoServiceTest {

	@Mock
	private AlunoRepository alunoRepository;

	@InjectMocks
	private AlunoService alunoService;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	// Quando um aluno for informado então ele será criado
	@Test
	void whenAlunoInformedThenItShouldBeCreated() {

		// Given
		AlunoDTO expectedAlunoDTO = new AlunoDTOBuilder().toAlunoDTO();
		Aluno expectedSavedAluno = new AlunoMapper().convertFromAlunoDTO(expectedAlunoDTO);

		// when
		when(alunoRepository.findById(expectedAlunoDTO.getMatricula())).thenReturn(Optional.empty());
		when(alunoRepository.save(expectedSavedAluno)).thenReturn(expectedSavedAluno); 

		// Then
		Aluno createdAluno = alunoService.createAluno(expectedSavedAluno);
		AlunoDTO createdAlunoDTO = new AlunoMapper().convertToAlunoDTO(createdAluno);

		assertThat(createdAlunoDTO.getMatricula(), is(equalTo(expectedAlunoDTO.getMatricula())));
		assertThat(createdAlunoDTO.getNome(), is(equalTo(expectedAlunoDTO.getNome())));
		// OBS.: deve-se utilizar a bilioteca import static
		// org.hamcrest.MatcherAssert.assertThat;
	}

	@Test
	void whenAlreadyRegisteredInformedThenException() {

		// given
		AlunoDTO expectedAlunoDTO = new AlunoDTOBuilder().toAlunoDTO();
		Aluno duplicatedAluno = new AlunoMapper().convertFromAlunoDTO(expectedAlunoDTO);

		// When
		when(alunoRepository.findById(expectedAlunoDTO.getMatricula())).thenReturn(Optional.of(duplicatedAluno));

		// Then
		assertThrows(RuntimeException.class, () -> alunoService.createAluno(duplicatedAluno));
	}

	@Test
	void whenValidAlunoIsGivenThenReturnAluno() {

		// Given
		AlunoDTOBuilder alunoDTObuilder = new AlunoDTOBuilder();
		AlunoMapper am = new AlunoMapper();
		AlunoDTO expectedFoundAlunoDTO = alunoDTObuilder.toAlunoDTO(); //(1, ANTONIO)
		Aluno expectedFoundAluno = am.convertFromAlunoDTO(expectedFoundAlunoDTO);//(1, ANTONIO, NULL, NULL)

		// when
		when(alunoRepository.findById(expectedFoundAlunoDTO.getMatricula()))
				.thenReturn(Optional.of(expectedFoundAluno));

		// Then
		Aluno foundAluno = alunoService.getAlunoById(expectedFoundAlunoDTO.getMatricula());
		AlunoDTO foundAlunoDTO = new AlunoMapper().convertToAlunoDTO(foundAluno); //AQUI
		assertThat(foundAlunoDTO, is(equalTo(expectedFoundAlunoDTO)));
	}

	// Buscar um aluno que não existe, logo retorna um vazio
	@Test
	void whenNotRegisteredAlunoIsGivenThenThrowException() {

		// Given
		AlunoDTO expectedFoundAlunoDTO = new AlunoDTOBuilder().toAlunoDTO();

		// when
		when(alunoRepository.findById(expectedFoundAlunoDTO.getMatricula())).thenReturn(Optional.empty());

		// Then
		assertThrows(RuntimeException.class, () -> alunoService.getAlunoById(expectedFoundAlunoDTO.getMatricula()));
	}

	// Quando uma lista de aluno é chamada, retornar uma lista vazia
	/*
	@Test
	void whenListAlunoIsCalledThenReturnAnEmptyListOfAluno() {

		// when
		when(alunoRepository.findAll()).thenReturn(Collections.emptyList());

		// Then
		List<AlunoDTO> foundListAlunoDTO = alunoController.getAluno();
		assertThat(foundListAlunoDTO, is(empty()));
	}
	*/
}

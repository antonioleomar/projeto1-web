package com.projeto1.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.projeto1.web.builder.AlunoDTOBuilder;
import com.projeto1.web.builder.ProfessorBuilder;
import com.projeto1.web.domain.Aluno;
import com.projeto1.web.domain.Professor;
import com.projeto1.web.dto.AlunoDTO;
import com.projeto1.web.mapper.AlunoMapper;
import com.projeto1.web.repository.AlunoRepository;
import com.projeto1.web.repository.ProfessorRepository;
import com.projeto1.web.services.AlunoService;
import com.projeto1.web.services.ProfessorService;

public class ProfessorServiceTest {
	
	@Mock
	private ProfessorRepository professorRepository;

	@InjectMocks
	private ProfessorService professorService;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void whenProfessorInformedThenItShouldBeCreated() {

		// Given
		Professor professorSaved = new ProfessorBuilder().toProfessor();		

		// when
		when(professorRepository.findById(professorSaved.getMatricula())).thenReturn(Optional.empty());
		when(professorRepository.save(professorSaved)).thenReturn(professorSaved); 

		// Then
		Professor createdProfessor = professorService.createProfessor(professorSaved);		

		assertThat(createdProfessor.getMatricula(), is(equalTo(professorSaved.getMatricula())));
		assertThat(createdProfessor.getNome(), is(equalTo(professorSaved.getNome())));
		// OBS.: deve-se utilizar a bilioteca import static
		// org.hamcrest.MatcherAssert.assertThat;
	}
	
	@Test
	void whenAlreadyRegisteredInformedThenException() {

		// given
		Professor expectedProfessor = new ProfessorBuilder().toProfessor();
		Professor duplicatedProfessor = new Professor(expectedProfessor.getMatricula(), expectedProfessor.getNome(), expectedProfessor.getFormacao(), expectedProfessor.getEmail());

		// When
		when(professorRepository.findById(expectedProfessor.getMatricula())).thenReturn(Optional.of(duplicatedProfessor));

		// Then
		assertThrows(RuntimeException.class, () -> professorService.createProfessor(duplicatedProfessor));
	}
	
	@Test
	void whenValidProfessorIsGivenThenReturnAluno() {

		// Given
		ProfessorBuilder professorbuilder = new ProfessorBuilder();		
		Professor expectedFoundProfessor = professorbuilder.toProfessor(); 
		

		// when
		when(professorRepository.findById(expectedFoundProfessor.getMatricula()))
				.thenReturn(Optional.of(expectedFoundProfessor));

		// Then
		Optional<Professor> foundProfessor = professorService.getProfessorById(expectedFoundProfessor.getMatricula());		
		assertThat(foundProfessor, is(equalTo(expectedFoundProfessor)));
	}
	
	@Test
	void whenNotRegisteredProfessorIsGivenThenThrowException() {

		// Given
		ProfessorBuilder professorbuilder = new ProfessorBuilder();		
		Professor expectedFoundProfessor = professorbuilder.toProfessor();

		// when
		when(professorRepository.findById(expectedFoundProfessor.getMatricula())).thenReturn(Optional.empty());

		// Then
		assertThrows(RuntimeException.class, () -> professorService.getProfessorById(expectedFoundProfessor.getMatricula()));
	}



}

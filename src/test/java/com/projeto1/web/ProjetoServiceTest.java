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

import com.projeto1.web.builder.ProfessorBuilder;
import com.projeto1.web.builder.ProjetoBuilder;
import com.projeto1.web.domain.Professor;
import com.projeto1.web.domain.Projeto;
import com.projeto1.web.repository.ProfessorRepository;
import com.projeto1.web.repository.ProjetoRepository;
import com.projeto1.web.services.ProfessorService;
import com.projeto1.web.services.ProjetoService;

public class ProjetoServiceTest {

	@Mock
	private ProjetoRepository projetoRepository;

	@InjectMocks
	private ProjetoService projetoService;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void whenProjetoInformedThenItShouldBeCreated() {

		// Given
		Projeto projetoSaved = new ProjetoBuilder().toProjeto();

		// when
		when(projetoRepository.findById(projetoSaved.getCodigo())).thenReturn(Optional.empty());
		when(projetoRepository.save(projetoSaved)).thenReturn(projetoSaved);

		// Then
		Projeto createdProjeto = projetoService.createProjeto(projetoSaved);

		assertThat(createdProjeto.getCodigo(), is(equalTo(projetoSaved.getCodigo())));
		assertThat(createdProjeto.getNome(), is(equalTo(projetoSaved.getNome())));
		// OBS.: deve-se utilizar a bilioteca import static
		// org.hamcrest.MatcherAssert.assertThat;
	}

	@Test
	void whenAlreadyRegisteredInformedThenException() {

		// given
		Projeto expectedProjeto = new ProjetoBuilder().toProjeto();
		Projeto duplicatedProjeto = new Projeto(expectedProjeto.getCodigo(), expectedProjeto.getNome(),
				expectedProjeto.getDescricao());

		// When
		when(projetoRepository.findById(expectedProjeto.getCodigo()))
				.thenReturn(Optional.of(duplicatedProjeto));

		// Then
		assertThrows(RuntimeException.class, () -> projetoService.createProjeto(duplicatedProjeto));
	}

	@Test
	void whenValidProjetoIsGivenThenReturnAluno() {

		// Given
		ProjetoBuilder projetobuilder = new ProjetoBuilder();
		Projeto expectedFoundProjeto = projetobuilder.toProjeto();

		// when
		when(projetoRepository.findById(expectedFoundProjeto.getCodigo()))
				.thenReturn(Optional.of(expectedFoundProjeto));

		// Then
		Optional<Projeto> foundProjeto = projetoService.getProjetoById(expectedFoundProjeto.getCodigo());
		assertThat(foundProjeto, is(equalTo(expectedFoundProjeto)));
	}

	@Test
	void whenNotRegisteredProjetoIsGivenThenThrowException() {

		// Given
		ProjetoBuilder projetobuilder = new ProjetoBuilder();
		Projeto expectedFoundProjeto = projetobuilder.toProjeto();

		// when
		when(projetoRepository.findById(expectedFoundProjeto.getCodigo())).thenReturn(Optional.empty());

		// Then
		assertThrows(RuntimeException.class,
				() -> projetoService.getProjetoById(expectedFoundProjeto.getCodigo()));
	}

}

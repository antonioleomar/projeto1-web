package com.projeto1.web.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto1.web.domain.Aluno;
import com.projeto1.web.dto.AlunoDTO;
import com.projeto1.web.mapper.AlunoMapper;
import com.projeto1.web.services.AlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/aluno")
@Api(value = "Aluno Controller")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
    @Autowired
    private AlunoMapper alunoMapper;


	@GetMapping
	@ApiOperation(value = "Busca uma lista de todos os alunos")
	public List<AlunoDTO> getAluno(){
		List<Aluno> alunos = alunoService.getAluno();
		return alunos.stream()
                .map(alunoMapper::convertToAlunoDTO)
                .collect(Collectors.toList());
	}
	
	@GetMapping("/{matricula}")
	@ApiOperation(value = "Busca um aluno pelo seu identificador")
	public ResponseEntity<?> getAlunoById(@PathVariable Long matricula){		
            return new ResponseEntity<>(alunoMapper.convertToAlunoDTO(alunoService.getAlunoById(matricula)), HttpStatus.OK);        
	}
	
	@PostMapping 
	@ApiOperation(value = "Cria um novo aluno")
	public Aluno  createAluno(@RequestBody AlunoDTO alunoDTO) {
		Aluno aluno = alunoMapper.convertFromAlunoDTO(alunoDTO);
		System.out.println("Aluno Nome: " + alunoDTO.getMatricula());
        return alunoService.createAluno(aluno);
	}
	
	@PutMapping("/{matricula}")
	@ApiOperation(value = "Atualiza um aluno a partir do seu identificador")
	public AlunoDTO updateAluno(@PathVariable("matricula")Long matricula, @RequestBody AlunoDTO alunoDTO) {
		Aluno aluno = alunoMapper.convertFromAlunoDTO(alunoDTO);
        return alunoMapper.convertToAlunoDTO(alunoService.updateAluno(matricula, aluno));
	}
	
	@DeleteMapping("/{matricula}")
	@ApiOperation(value = "Exclui um aluno a partir do seu identificador")
	public void deleteAluno(@PathVariable Long matricula) {
		alunoService.deleteAluno(matricula);
	}
}

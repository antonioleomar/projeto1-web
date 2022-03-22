package com.projeto1.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.projeto1.web.domain.Aluno;
import com.projeto1.web.domain.User;
import com.projeto1.web.dto.AlunoDTO;

public class AlunoMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public AlunoDTO convertToAlunoDTO(Aluno aluno) {
        AlunoDTO alunoDTO = modelMapper.map(aluno, AlunoDTO.class);
        return alunoDTO;
    }

    public Aluno convertFromAlunoDTO(AlunoDTO alunoDTO) {
        Aluno aluno = modelMapper.map(alunoDTO, Aluno.class);    
        return aluno;
    }
}

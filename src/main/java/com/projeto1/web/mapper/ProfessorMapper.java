package com.projeto1.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.projeto1.web.domain.Professor;
import com.projeto1.web.dto.ProfessorDTO;

public class ProfessorMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public ProfessorDTO convertToProfessorDTO(Professor professor) {
        ProfessorDTO professorDTO = modelMapper.map(professor, ProfessorDTO.class);
        return professorDTO;
    }

    public Professor convertFromProfessorDTO(ProfessorDTO professorDTO) {
        Professor professor = modelMapper.map(professorDTO, Professor.class);    
        return professor;
    }
}

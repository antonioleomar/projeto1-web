package com.projeto1.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.projeto1.web.domain.Turma;
import com.projeto1.web.domain.User;
import com.projeto1.web.dto.TurmaDTO;
import com.projeto1.web.dto.UserDTO;

public class TurmaMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public TurmaDTO convertToTurmaDTO(Turma turma) {
        TurmaDTO turmaDTO = modelMapper.map(turma, TurmaDTO.class);
        return turmaDTO;
    }

    public Turma convertFromTurmaDTO(TurmaDTO turmaDTO) {
        Turma turma = modelMapper.map(turmaDTO, Turma.class);    
        return turma;
    }
}

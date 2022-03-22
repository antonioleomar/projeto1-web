package com.projeto1.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.projeto1.web.domain.Aluno;
import com.projeto1.web.domain.Projeto;
import com.projeto1.web.domain.User;
import com.projeto1.web.dto.AlunoDTO;
import com.projeto1.web.dto.ProjetoDTO;

public class ProjetoMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public ProjetoDTO convertToProjetoDTO(Projeto projeto) {
        ProjetoDTO projetoDTO = modelMapper.map(projeto, ProjetoDTO.class);
        return projetoDTO;
    }

    public Projeto convertFromProjetoDTO(ProjetoDTO projetoDTO) {
        Projeto projeto = modelMapper.map(projetoDTO, Projeto.class);    
        return projeto;
    }
}

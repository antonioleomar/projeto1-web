package com.projeto1.web.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto1.web.mapper.ProfessorMapper;


@Configuration
public class ProfessorMapperConfig {
	
	@Bean
    public ModelMapper modelMapper2() {
        return new ModelMapper();
    }

    @Bean
    public ProfessorMapper professorMapper() {
        return new ProfessorMapper();
    }
}

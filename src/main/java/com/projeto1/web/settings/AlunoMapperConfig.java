package com.projeto1.web.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto1.web.mapper.AlunoMapper;
import com.projeto1.web.mapper.UserMapper;

@Configuration
public class AlunoMapperConfig {
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public AlunoMapper alunoMapper() {
        return new AlunoMapper();
    }
}

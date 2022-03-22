package com.projeto1.web.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto1.web.mapper.ProjetoMapper;
import com.projeto1.web.mapper.TurmaMapper;
import com.projeto1.web.mapper.UserMapper;

@Configuration
public class TurmaMapperConfig {
	
	@Bean
    public ModelMapper modelMapper4() {
        return new ModelMapper();
    }

    @Bean
    public TurmaMapper turmaMapper() {
        return new TurmaMapper();
    }
}

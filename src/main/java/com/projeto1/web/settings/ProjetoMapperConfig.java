package com.projeto1.web.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto1.web.mapper.ProjetoMapper;
import com.projeto1.web.mapper.UserMapper;

@Configuration
public class ProjetoMapperConfig {
	
	@Bean
    public ModelMapper modelMapper3() {
        return new ModelMapper();
    }

    @Bean
    public ProjetoMapper projetoMapper() {
        return new ProjetoMapper();
    }
}

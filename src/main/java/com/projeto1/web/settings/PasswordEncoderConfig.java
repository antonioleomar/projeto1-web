package com.projeto1.web.settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
	
	@Bean
    BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();        
    }
	// PARA CRIPTOGRAFAR USAMOS O ALGORITMO BCRYPT
	//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //System.out.println(getEncoder().encode("12345"));
	//Resposta: igjoigomdvndfoinofnomo
}

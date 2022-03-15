package com.projeto1.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto1.web.domain.User;
import com.projeto1.web.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; //criptografar a senha do usuário

    public void signUpUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);        
    }
}

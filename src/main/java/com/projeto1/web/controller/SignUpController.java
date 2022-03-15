package com.projeto1.web.controller;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto1.web.dto.UserDTO;
import com.projeto1.web.mapper.UserMapper;
import com.projeto1.web.services.UserService;

//APENAS PARA CADASTRAR USUÁRIOS

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
public class SignUpController {
	
	@Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/signup")
    public void signUp(@RequestBody UserDTO userDTO){
        userService.signUpUser(userMapper.convertFromUserDTO(userDTO));
    }
}

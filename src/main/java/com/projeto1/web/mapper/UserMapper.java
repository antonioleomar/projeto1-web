package com.projeto1.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.projeto1.web.domain.User;
import com.projeto1.web.dto.UserDTO;

public class UserMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public User convertFromUserDTO(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);    
        return user;
    }
}

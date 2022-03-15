package com.projeto1.web.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {	
	
    @JsonProperty("username")
    private String username;    
    
    @JsonProperty("password")
    private String password;
    
    public UserDTO() {}

}

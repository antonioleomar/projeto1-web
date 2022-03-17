package com.projeto1.web.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    @JsonProperty
    private String username;
    
    @Column(name = "password")
    @JsonProperty
    private String password; 
    
    @Column(name = "ÉProfessor")
    @JsonProperty
    private boolean eProfessor; 
    
    
    public User() {}
	
   
	public String getUsername() {
		return username;
	}
    
	public void setUsername(String username) {
		this.username = username;
	}
    
	public String getPassword() {
		return password;
	}
    
	public void setPassword(String password) {
		this.password = password;
	}


	public boolean iseProfessor() {
		return eProfessor;
	}


	public void seteProfessor(boolean eProfessor) {
		this.eProfessor = eProfessor;
	}	
	
}

package com.projeto1.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto1.web.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}

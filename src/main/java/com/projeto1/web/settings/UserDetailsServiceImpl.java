package com.projeto1.web.settings;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.projeto1.web.domain.User;
import com.projeto1.web.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;		
	
	@Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {		
		this.userRepository = userRepository;
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        
        //Criando 2 listas: Professores X Alunos
        List<GrantedAuthority> authorityListProfessor =  AuthorityUtils.createAuthorityList("ROLE_PROFESSOR");
        List<GrantedAuthority> authorityLisAluno =  AuthorityUtils.createAuthorityList("ROLE_ALUNO");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.iseProfessor() ? authorityListProfessor : authorityLisAluno );
        //
        //return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

}

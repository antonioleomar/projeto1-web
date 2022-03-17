package com.projeto1.web.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.projeto1.web.domain.User;

@Component
public class UsuarioAutenticado {

	private User getUsuarioAutenticado() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			Object obj = authentication.getPrincipal();
			if (obj instanceof User) {
				return (User) obj;
			}
		}
		return null;
	}
	
	public boolean getUsuarioFuncao() {
        boolean usu = getUsuarioAutenticado().iseProfessor();
        return usu;
    }
}

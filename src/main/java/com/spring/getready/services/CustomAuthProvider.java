package com.spring.getready.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
				
		if(username.equals("sethu") && password.equals("pass")) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	        return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
		}
		else {
			return null;
		}
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}

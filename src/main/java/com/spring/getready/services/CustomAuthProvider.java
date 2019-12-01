package com.spring.getready.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.getready.model.UserDetail;
import com.spring.getready.repository.UserDetailRepository;

@Service
public class CustomAuthProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		UserDetail userDetail = userDetailRepository.findByEmailEquals(username);

		if (userDetail != null && passwordEncoder.matches(password, userDetail.getPassword())) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			if (userDetail.getUserGroup().getGroupName().equals("ADMIN")) {
				grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			} else {
				grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			}
			userDetail.setLastLoginOn(new Timestamp(new Date().getTime()));
			userDetailRepository.save(userDetail);
			return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

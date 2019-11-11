package com.spring.getready.interceptor;

import java.io.IOException;
import java.util.Collection;

//import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		handleRedirects(request, response, authentication);
	}

	protected void handleRedirects(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		boolean isUser = false;
		boolean isAdmin = false;
		String targetUrl = null;

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
				isUser = true;
				break;
			}
			if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			}
		}

		if (isUser) {
			targetUrl = "/home";
		} else if (isAdmin) {
			targetUrl = "/admin";
		} else {
			targetUrl = "/error";
		}

		if (response.isCommitted()) {
			// debug code here
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

//	protected void clearAuthenticationAttributes(HttpServletRequest request) {
//		HttpSession session = request.getSession(false);
//		if (session == null) {
//			return;
//		}
//		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//	}

}

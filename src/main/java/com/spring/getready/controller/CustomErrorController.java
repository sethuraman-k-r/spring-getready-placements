package com.spring.getready.controller;

//import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
//		String status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
//		String uri = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI).toString();
//		String message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE).toString();
		UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) request
				.getUserPrincipal();
//		System.out.println(authenticationToken.getAuthorities());
		return "error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}

package com.spring.getready.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.getready.model.UserDetail;
import com.spring.getready.repository.UserDetailRepository;

@Controller
public class AdminController {

	@Autowired
	private UserDetailRepository userDetailRepository;

	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	public String getAdminHome(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetail userDetail = userDetailRepository.findByEmailEquals(username);
		model.addAttribute("username", userDetail.getUsername());
		return "admin";
	}

}

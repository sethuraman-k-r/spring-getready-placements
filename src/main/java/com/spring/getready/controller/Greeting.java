package com.spring.getready.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Greeting {

	@GetMapping(path = "/greet")
	public String getGreeting(Model model) {
		return "greeting";
	}
	
}

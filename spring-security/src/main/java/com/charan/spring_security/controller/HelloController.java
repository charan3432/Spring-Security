package com.charan.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String greet(HttpServletRequest request) {
		return "Hello World "+request.getSession().getId();
	}
	
	@GetMapping("/hello/about")
	public String about() {
		return "Nothing about me....";
	}
}

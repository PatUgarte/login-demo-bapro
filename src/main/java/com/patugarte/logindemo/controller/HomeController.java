package com.patugarte.logindemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("home")
public class HomeController {

	@GetMapping()
	public String irAlHome() {
		return "home";
	}
	
	@PostMapping()
	public String irAlHomePost() {
		return "home";
	}
}

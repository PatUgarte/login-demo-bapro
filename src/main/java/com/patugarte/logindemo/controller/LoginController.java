package com.patugarte.logindemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patugarte.logindemo.model.User;
import com.patugarte.logindemo.repository.UserJpaRepository;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	@GetMapping()
	public String irAlLogin() {
		return "login";
	}
	
	@PostMapping()
	public String comprobarLogin(Model model, User user) {
		
		String mailIngresado = user.getEmail();
		String contraseniaIngresada = user.getPassword();
		
		User usuarioEncontrado = userJpaRepository.findByEmail(mailIngresado);
		
		if(usuarioEncontrado == null) {
			return "error";
		}
		
		if(usuarioEncontrado.getPassword().equals(contraseniaIngresada)) {
			model.addAttribute("userName", usuarioEncontrado.getUserName());
			return "home";
		} else {
			return "error";
		}

	}
}

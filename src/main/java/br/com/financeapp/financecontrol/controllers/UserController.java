package br.com.financeapp.financecontrol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.financeapp.financecontrol.models.entities.User;
import br.com.financeapp.financecontrol.models.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registerUser() {
		return "user/register";
	}
	
	@PostMapping("/login")
	public void loginUser(User user) {
		
	}
}

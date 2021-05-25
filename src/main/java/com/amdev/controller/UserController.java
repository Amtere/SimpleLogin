package com.amdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amdev.entity.User;
import com.amdev.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listUser(Model theModel) {
		
		List<User> usuarios = userService.getUsers();      
		System.out.println(usuarios.toString());
		theModel.addAttribute("users", usuarios);
		
		return "list-users";
	}
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveCustomer(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/user/list";
	}
}

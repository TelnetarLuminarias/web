package com.telnetar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.telnetar.Util;
import com.telnetar.model.User;
import com.telnetar.services.UserService;

@Controller(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "users/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute User user, Model model) {
		// implement your own registration logic here...

		// for testing purpose:
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("enabled: " + user.getEnabled());
		user.setPassword(Util.hashPassword(user.getPassword()));
		userService.register(user);
		return "users/register";
	}
}

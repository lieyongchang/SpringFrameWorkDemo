package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.repository.UserRepository;

@Controller
public class UserController {

	private final UserRepository userRepo;

	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping("/user.html")
	public String showUserList(Map<String, Object> model) {
		// Here we are returning an object of type 'Vets' rather than a collection of
		// Vet
		// objects so it is simpler for Object-Xml mapping
		/*
		 * UserDomain userDomain = new UserDomain();
		 * userDomain.getVetList().addAll(this.userRepo.findAll()); model.put("users",
		 * userRepo);
		 */
		return "user/userList";
	}

}

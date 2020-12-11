package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.repository.UserRepository;

@Controller
public class UserController {

//	private final UserInfoService userInfoService;
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String ListUserInfo(Model model) {
		model.addAttribute("userlist", userRepository.findAll());

		return "/user/userList";

	}

}

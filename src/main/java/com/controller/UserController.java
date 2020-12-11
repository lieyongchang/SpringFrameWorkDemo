package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.UserInfoService;

@Controller
public class UserController {

	private final UserInfoService userInfoService;
	// private final UserRepository userRepository;

	@Autowired
	public UserController(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@RequestMapping(value = "/userList")
	public String ListUserInfo(Model model) {

		model.addAttribute("userlist", userInfoService.users);

		return "/user/userList";

	}

}

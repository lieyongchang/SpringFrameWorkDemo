package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserInfoService;

/**
 * @author yongchang Only redirects
 */
@Controller
public class UserController {

	private final UserInfoService userInfoService;
	private final UserRepository userRepository;

	@Autowired
	public UserController(UserInfoService userInfoService, UserRepository userRepository) {
		this.userInfoService = userInfoService;
		this.userRepository = userRepository;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userList")
	public String ListUserInfo(Model model) {

		model.addAttribute("userlist", userInfoService.users);

		return "/user/userList";

	}

	/**
	 * Update form
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	/*
	 * @GetMapping("/edit/{id}") public String showUpdateForm(@PathVariable("id")
	 * long id, Model model) { User user = userRepository.findById(id)
	 * .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	 * 
	 * model.addAttribute("user", user); return "update-user"; }
	 */
	/*
	 * */
	/**
	 * Update user
	 * 
	 * @param id
	 * @param user
	 * @param result
	 * @param model
	 * @return
	 */
	/*
	 * @PostMapping("/update/{id}") public String updateUser(@PathVariable("id")
	 * long id, @Valid User user, BindingResult result, Model model) { if
	 * (result.hasErrors()) { user.setId(id); return "update-user"; }
	 * 
	 * userRepository.save(user); model.addAttribute("users",
	 * userRepository.findAll()); return "/"; }
	 */

	/**
	 * Delete
	 * 
	 * @param id
	 * @param model
	 * @return
	 */

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id)
		        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userRepository.delete(user);
		model.addAttribute("users", userRepository.findAll());
		return "/user/userList";
	}

}

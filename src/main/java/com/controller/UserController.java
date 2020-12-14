package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.User;
import com.service.UserInfoService;

/**
 * @author yongchang Only redirects
 */
@Controller
public class UserController {

	private final UserInfoService userInfoService;

	@Autowired
	public UserController(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	/**
	 * List all the user from the database
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userList")
	public String ListUserInfo(Model model) {

		model.addAttribute("userlist", userInfoService.getUser());
		return "/user/userList";

	}

	/**
	 * This will show the update-user.html
	 * 
	 * @param id
	 * @param model
	 * @return
	 */

	@RequestMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("user", userInfoService.findById(id));
		return "/user/update-user";
	}

	/**
	 * Update user
	 * 
	 * @param id
	 * @param user
	 * @param result
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateUser(@Valid User user, Model model) {
		model.addAttribute("users", userInfoService.saveUserCommand(user));

		return "/user/userList";
	}

	/**
	 * Delete user
	 * 
	 * @param id
	 * @param model
	 * @return
	 */

	@GetMapping
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {

		userInfoService.deleteById(Long.valueOf(id));

		return "/user/userList";
	}

}

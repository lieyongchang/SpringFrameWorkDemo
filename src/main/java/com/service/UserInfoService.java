package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.model.User;
import com.repository.UserRepository;

import Validator.UserValidator;

@Service
public class UserInfoService {
	@Autowired
	private UserRepository userRepository;

	/*
	 * 
	 * 
	 * 
	 * */

	public String addUserInfo(User user, BindingResult bindingResult) {

		// Condition to check if the contact field matches with the Email/Mobile field
		if (user.getContact().equalsIgnoreCase("Email")) {
			user.setContact(user.getEmail());
		} else if (user.getContact().equalsIgnoreCase("Mobile") && user.getMobile() != 0) {
			System.out.print("enter here");
			user.setContact(Integer.toString(user.getMobile()));
		}

		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "welcome";
		} else {
			userRepository.save(user);
			return "register_success";
		}
	}
}

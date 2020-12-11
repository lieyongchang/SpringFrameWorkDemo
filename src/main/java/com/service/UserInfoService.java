package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.model.User;

import Validator.UserValidator;

@Service
public class UserInfoService {

	private List<User> users;

	/*
	 * 
	 * 
	 * 
	 * */

	public void addUserInfo(User user, BindingResult bindingResult) {

		if (this.users != null)
			users.add(user);
		// Condition to check if the contact field matches with the Email/Mobile field
		if (user.getContact() != null && user.getContact().equalsIgnoreCase("Email")) {
			user.setContact(user.getEmail());

		} else if (user.getContact().equalsIgnoreCase("Mobile") && user.getMobile() != 0) {
//			System.out.print("enter here");
			user.setContact(Integer.toString(user.getMobile()));
		}

		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, bindingResult);

		// add data into my list

	}

//	public List<User> listAll() {
//		return userRepository.findAll();
//	}
}

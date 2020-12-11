package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.model.User;
import com.repository.UserRepository;

import Validator.UserValidator;

@Service
public class UserInfoService {

	public List<User> users = new ArrayList<>();

	private UserRepository userRepository;

	public UserInfoService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public void addUserInfo(User user, BindingResult bindingResult) {

		if (user != null) {
			users.add(user);
		}

		// Condition to check if the contact field matches with the Email/Mobile field
		if (user.getContact() != null && user.getContact().equalsIgnoreCase("Email")) {
			user.setContact(user.getEmail());

		} else if (user.getContact().equalsIgnoreCase("Mobile") && user.getMobile() != 0) {
			user.setContact(Integer.toString(user.getMobile()));
		}

		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, bindingResult);

		// This will push to pretendco_yc
		userRepository.save(user);
	}

}

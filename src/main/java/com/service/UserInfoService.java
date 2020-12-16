package com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.model.User;
import com.repository.UserRepository;

import Validator.UserValidator;

/**
 * @author yongchang Business logic
 */
@Service
public class UserInfoService {

	public List<User> users = new ArrayList<>();

	private UserRepository userRepository;

	public UserInfoService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	/**
	 * @param user
	 * @param bindingResult
	 */
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

	/**
	 * @return
	 */
	public Set<User> getUser() {
		// recipeSet is just a container
		Set<User> userSet = new HashSet<>();

		// go through recipe repo, and put everything into the container
		userRepository.findAll().iterator().forEachRemaining(userSet::add);
		return userSet;
	}

	/**
	 * @param user
	 * @return
	 */
	@Transactional
	public User saveUserCommand(User user) {

		User saveUser = userRepository.save(user);
		return saveUser;

	}

	/**
	 * @param id
	 * @return
	 */
	public User findById(long id) {
		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent()) {
			throw new RuntimeException("User Not Found!");
		}

		return userOptional.get();
	}

	/**
	 * @param idToDelete
	 */
	public void deleteById(Long idToDelete) {
		userRepository.deleteById(idToDelete);
	}
}

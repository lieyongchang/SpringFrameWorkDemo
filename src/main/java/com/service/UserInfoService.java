package com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserInfoService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	/**
	 * @param user
	 * @param bindingResult
	 */
	public String addUserInfo(User user, BindingResult bindingResult) {

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

//		System.out.println("yc: " + isEmailExist(user.getEmail()));
		if (isEmailExist(user.getEmail()) || isMobileExist(user.getMobile())) {
			System.out.println("got duplicate email/mobile");
		} else {
			userRepository.save(user);
			return "register_success";
		}

		// This will push to pretendco_yc
		return "Duplicate email/mobile number";
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

	/**
	 * @param email
	 */
	public boolean isEmailExist(String email) {
		String sql = "SELECT count(*) FROM user WHERE email=?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] { email }, Integer.class);
		return count > 0;
	}

	/**
	 * @param email
	 */
	public boolean isMobileExist(Integer mobile) {
		String sql = "SELECT count(*) FROM user WHERE mobile=?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] { mobile }, Integer.class);
		return count > 0;
	}
}

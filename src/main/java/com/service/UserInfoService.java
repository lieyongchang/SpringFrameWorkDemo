package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserInfoService {
	@Autowired
	private UserRepository userRepository;

	public void addUserInfo(User userInfo) {
		userRepository.save(userInfo);
	}
}

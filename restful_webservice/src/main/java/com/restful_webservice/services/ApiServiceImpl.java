package com.restful_webservice.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.domain.User;
import com.api.domain.UserData;

@Service
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;

	public ApiServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<User> getUsers(Integer limit) {
		List<User> userData = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users?limit=" + limit, List.class);
		return userData;
	}

}

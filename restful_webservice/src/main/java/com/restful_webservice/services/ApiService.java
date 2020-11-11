package com.restful_webservice.services;

import java.util.List;

import com.api.domain.User;

public interface ApiService {
	List<User> getUsers(Integer limit);
}

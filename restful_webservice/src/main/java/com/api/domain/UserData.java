package com.api.domain;

import java.util.List;

/*
 * 
 * Fetch the whole data from restful api and store it inside here
 * 
 * */

public class UserData {
	List<User> data;

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

}

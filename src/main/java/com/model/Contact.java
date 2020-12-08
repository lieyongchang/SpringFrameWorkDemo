package com.model;

public class Contact {
	private int mobile;
	private String email;

	public Contact(int mobile, String email) {
		super();
		this.mobile = mobile;
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

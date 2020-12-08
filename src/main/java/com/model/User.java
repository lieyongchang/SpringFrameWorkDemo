package com.model;

public class User {
	private String name;
	private int age;
	private String gender;
	private String country;
	private String email;
	private int mobile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public User(String name, int age, String gender, String country, String email, int mobile) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.country = country;
		this.email = email;
		this.mobile = mobile;
	}

}

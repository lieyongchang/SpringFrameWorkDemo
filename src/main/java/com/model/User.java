package com.model;

public class User {
	private String name;
	private int age;
	private String gender;
	private String country;

	public String getName() {
		return name;
	}

	public User(String name, int age, String gender, String country) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.country = country;
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
}

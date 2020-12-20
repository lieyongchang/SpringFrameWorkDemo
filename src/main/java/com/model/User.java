package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User {

	public enum GENDER {
		MALE, FEMALE, OTHERS
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name")
	@Size(min = 3, max = 50)
	private String name;

	@Column(name = "Age")
	private Integer age;

	@Column(name = "Gender")
	private GENDER gender;

	@Column(name = "Country")
	private String country;

	@Column(name = "Email")
	@NotBlank
	@Email(message = "Please enter a valid e-mail address")
	private String email;

	@Column(name = "Mobile")
	private Integer mobile;

	@Column(name = "contact")
	private String contact;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
//	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "DOB")
	private Date birthdate;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

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

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
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

	public User() {
	}

	public User(String name, Integer age, GENDER gender, String country, String email, Integer mobile, String contact,
			Date birthdate, String message) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.country = country;
		this.email = email;
		this.mobile = mobile;
		this.contact = contact;
		this.birthdate = birthdate;
		this.message = message;
	}

}

package com.example.MyFirstSpringBootDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//rest controller means it is ready for use by Spring MVC to handle web requests.
@RestController
public class HelloWorld {

	// @RequestMapping maps / to the sayHello() method.
	@RequestMapping(value = "/")
	public String sayHello() {
		return "Hellow world";
	}
}

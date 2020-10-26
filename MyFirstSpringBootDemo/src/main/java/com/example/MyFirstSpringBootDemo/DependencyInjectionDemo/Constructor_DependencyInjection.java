package com.example.MyFirstSpringBootDemo.DependencyInjectionDemo;

import org.springframework.stereotype.Controller;

//This is about Dependency Injection Demo using constructor

@Controller
public class Constructor_DependencyInjection {

	private final GreetingService technology;

	public Constructor_DependencyInjection(GreetingService technology) {
		this.technology = technology;
	}

	public void display() {
		System.out.println("Object Returned Successfully");
		technology.displayMessage();
	}

}

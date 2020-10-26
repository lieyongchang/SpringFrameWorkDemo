package com.example.MyFirstSpringBootDemo.DependencyInjectionDemo;

import org.springframework.stereotype.Controller;

@Controller
public class GreetingService {

	public void displayMessage() {
		System.out.print("This is Technology Class");
	}

}

package com.example.DependencyInjection.Controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

	public String SayHello() {
		System.out.println("helloworld");

		return "test";
	}
}

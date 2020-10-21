package com.example.DependencyInjection.Controller;

import org.springframework.stereotype.Controller;

import com.example.DependencyInjection.Service.IGreetingService;

@Controller
public class MyController {

	private final IGreetingService greetingService;

	public MyController(IGreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String SayHello() {
		return greetingService.Greeting();
	}
}

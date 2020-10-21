package com.example.DependencyInjection.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.DependencyInjection.Service.ConstructorGreetingService;

@Controller
public class ConstructorInjectedController {
	private final ConstructorGreetingService greetingService;

	public ConstructorInjectedController(
			@Qualifier("constructorGreetingService") ConstructorGreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String sayGreeting() {
		return greetingService.Greeting();
	}

}

package com.example.DependencyInjection.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.DependencyInjection.Controller.ConstructorInjectedController;
import com.example.DependencyInjection.Service.ConstructorGreetingService;

public class ConstructorInjectedControllerTest {

	ConstructorInjectedController controller;

	@BeforeEach
	void setup() {
		controller = new ConstructorInjectedController(new ConstructorGreetingService());
	}

	@Test
	void getGreeting() {

		System.out.print(controller.sayGreeting());
	}
}

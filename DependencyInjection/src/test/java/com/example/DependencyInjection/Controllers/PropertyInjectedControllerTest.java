package com.example.DependencyInjection.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.DependencyInjection.Controller.PropertyInjectedController;
import com.example.DependencyInjection.Service.ConstructorGreetingService;

public class PropertyInjectedControllerTest {

	PropertyInjectedController controller;

	@BeforeEach
	void setup() {
		controller = new PropertyInjectedController();
		controller.greetingService = new ConstructorGreetingService();
	}

	@Test
	void getGreeting() {

		System.out.print(controller.sayGreeting());
	}

}

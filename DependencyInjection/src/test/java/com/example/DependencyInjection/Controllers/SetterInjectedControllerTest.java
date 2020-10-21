package com.example.DependencyInjection.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.DependencyInjection.Controller.SetterInjectedController;
import com.example.DependencyInjection.Service.ConstructorGreetingService;

public class SetterInjectedControllerTest {
	SetterInjectedController controller;

	@BeforeEach
	void setUp() {
		controller = new SetterInjectedController();
		controller.setGreetingService(new ConstructorGreetingService());
	}

	@Test
	void getGreeting() {
		System.out.println(controller.sayGreeting());

	}

}

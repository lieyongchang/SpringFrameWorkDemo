package com.example.DependencyInjection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.DependencyInjection.Service.IGreetingService;

@Controller
public class SetterInjectedController {
	@Qualifier("setterInjectionService")
	@Autowired
	private IGreetingService greetingService;

	public void setGreetingService(IGreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String sayGreeting() {
		return greetingService.Greeting();
	}

}

package com.example.conceptTesting.Controller;

import org.springframework.stereotype.Controller;

import com.example.conceptTesting.Service.GreetingServiceImpl;

@Controller
public class Employee {

	private final GreetingServiceImpl demoManagerService;

	public Employee(GreetingServiceImpl demoManagerService) {
		this.demoManagerService = demoManagerService;
	}

	public String printMessage() {
		return demoManagerService.getServiceName();
	}
}

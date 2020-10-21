package com.example.DependencyInjection.Service;

import org.springframework.stereotype.Service;

@Service
public class SetterInjectionService implements IGreetingService {

	@Override
	public String Greeting() {
		// TODO Auto-generated method stub
		return "Hi John --- setter";
	}

}

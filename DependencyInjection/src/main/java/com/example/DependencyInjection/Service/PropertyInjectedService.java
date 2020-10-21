package com.example.DependencyInjection.Service;

import org.springframework.stereotype.Service;

@Service
public class PropertyInjectedService implements IGreetingService {
	@Override
	public String Greeting() {
		// TODO Auto-generated method stub
		return "Hi John ---- PropertyInjection";
	}

}

package com.example.DependencyInjection.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryGreetingService implements IGreetingService {

	@Override
	public String Greeting() {
		// TODO Auto-generated method stub
		return "Hi John --- Primary Bean";
	}

}

package com.example.conceptTesting.Service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Override
	public String getServiceName() {
		// TODO Auto-generated method stub
		return "My first service with spring 3";
	}

}

package com.example.DependencyInjection.Service.Profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.DependencyInjection.Service.IGreetingService;

@Profile("EN")
@Service("i18nService")
public class I18nEnglishGreetingService implements IGreetingService {

	@Override
	public String Greeting() {
		// TODO Auto-generated method stub
		return "Hi John --- EN";
	}

}

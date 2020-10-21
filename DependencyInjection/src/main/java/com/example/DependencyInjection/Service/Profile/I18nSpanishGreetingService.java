package com.example.DependencyInjection.Service.Profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.DependencyInjection.Service.IGreetingService;

@Profile({ "ES", "default" })
@Service("i18nService")
public class I18nSpanishGreetingService implements IGreetingService {

	@Override
	public String Greeting() {
		// TODO Auto-generated method stub
		return "Hola Mundo-- ES";
	}

}

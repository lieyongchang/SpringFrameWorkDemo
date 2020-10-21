package com.example.DependencyInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.DependencyInjection.Controller.ConstructorInjectedController;
import com.example.DependencyInjection.Controller.MyController;
import com.example.DependencyInjection.Controller.PropertyInjectedController;
import com.example.DependencyInjection.Controller.SetterInjectedController;
import com.example.DependencyInjection.Controller.Profile.I18nController;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");

		System.out.println("------ I18nController");
		System.out.println(i18nController.sayHello());

		MyController controller = (MyController) ctx.getBean("myController");

		System.out.println("------ Primary");
		System.out.println(controller.SayHello());

		System.out.println("------ Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx
				.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.sayGreeting());

		System.out.println("--------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx
				.getBean("setterInjectedController");
		System.out.println(setterInjectedController.sayGreeting());

		System.out.println("-------- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx
				.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.sayGreeting());
	}

}

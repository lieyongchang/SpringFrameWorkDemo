package com.example.MyFirstSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.MyFirstSpringBootDemo.DependencyInjectionDemo.Constructor_DependencyInjection;

// it contains @Configuration, @EnableAutoConfiguration, @ComponentScan
@SpringBootApplication
public class MyFirstSpringBootDemoApplication {

	public static void main(String[] args) {

		// by default is the below code
		// SpringApplication.run(MyFirstSpringBootDemoApplication.class, args);

		// Uncomment to see Dependency Injection Demo in action
		ApplicationContext ctx = SpringApplication.run(MyFirstSpringBootDemoApplication.class, args);
		Constructor_DependencyInjection c = (Constructor_DependencyInjection) ctx
				.getBean("constructor_DependencyInjection");
		c.display();
	}

}

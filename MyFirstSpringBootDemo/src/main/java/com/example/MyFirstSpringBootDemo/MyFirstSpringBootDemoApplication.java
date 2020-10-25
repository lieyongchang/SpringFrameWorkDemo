package com.example.MyFirstSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// it contains @Configuration, @EnableAutoConfiguration, @ComponentScan
@SpringBootApplication
public class MyFirstSpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringBootDemoApplication.class, args);
//		HelloWorld displayMessage = new HelloWorld();
//		displayMessage.sayHello();
	}

}

package com.example.conceptTesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.conceptTesting.Controller.Employee;

@SpringBootApplication
public class ConceptTestingApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(ConceptTestingApplication.class, args);

		Employee employee = (Employee) ctx.getBean("employee");

		System.out.println(employee.printMessage());

	}

}

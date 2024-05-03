package com.project.weekassignment.week2.beanexample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MainApplication {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
			Config.class);

		Company company = context.getBean("company", Company.class);
		System.out.println("High Street".equals(company.getAddress().getStreet()));
		System.out.println(1000 == company.getAddress().getNumber());
	}
}

package com.project.weekassignment.week2.diexample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MainApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			= new AnnotationConfigApplicationContext(Config.class);

		Parent parent = context.getBean(Parent.class);

		parent.doSomething();
	}
}

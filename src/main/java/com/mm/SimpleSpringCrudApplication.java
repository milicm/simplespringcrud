package com.mm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class SimpleSpringCrudApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SimpleSpringCrudApplication().configure(new SpringApplicationBuilder(SimpleSpringCrudApplication.class))
				.run(args);
	}
}

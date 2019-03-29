package com.persteenolsen.springbootmvcjspjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.*;

@SpringBootApplication
public class SpringBootMvcJspJpaApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootMvcJspJpaApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcJspJpaApplication.class, args);
	}
}

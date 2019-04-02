package com.persteenolsen.springbootmvcjspjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.*;

// The main entry point of the Java Spring Boot Web Application
@SpringBootApplication
public class SpringBootMvcJspJpaApplication extends SpringBootServletInitializer {

    // Ready for builing a war file used for Tomcat
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootMvcJspJpaApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcJspJpaApplication.class, args);
	}
}

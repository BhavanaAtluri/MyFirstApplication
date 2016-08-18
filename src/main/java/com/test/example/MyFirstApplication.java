package com.test.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;


@SpringBootApplication
@EnableOAuth2Client
public class MyFirstApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstApplication.class, args);
	}	
}

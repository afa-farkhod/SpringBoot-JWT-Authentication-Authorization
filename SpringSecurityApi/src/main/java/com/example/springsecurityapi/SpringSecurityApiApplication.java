package com.example.springsecurityapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class SpringSecurityApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApiApplication.class, args);
	}

}

package com.spring.getready;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GetreadyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetreadyApplication.class, args);
	}

}

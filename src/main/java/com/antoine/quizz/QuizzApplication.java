package com.antoine.quizz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class QuizzApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzApplication.class, args);
	}

}

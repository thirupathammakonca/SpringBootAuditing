package com.thiruacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Au1Application {

	public static void main(String[] args) {
		SpringApplication.run(Au1Application.class, args);
	}

}

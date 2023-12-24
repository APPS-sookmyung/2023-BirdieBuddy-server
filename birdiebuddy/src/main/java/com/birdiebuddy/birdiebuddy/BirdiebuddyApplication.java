package com.birdiebuddy.birdiebuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "example")
@ComponentScan(basePackages = "example")
@SpringBootApplication
public class BirdiebuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirdiebuddyApplication.class, args);
	}
}

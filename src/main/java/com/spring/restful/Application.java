package com.spring.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Murali Kodavati
 *
 */

@SpringBootApplication
@EnableJpaRepositories
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

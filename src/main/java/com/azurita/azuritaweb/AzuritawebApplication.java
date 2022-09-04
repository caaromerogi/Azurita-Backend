package com.azurita.azuritaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AzuritawebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzuritawebApplication.class, args);
	}

}

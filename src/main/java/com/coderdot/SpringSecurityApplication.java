package com.coderdot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

@ComponentScan(basePackages = { "com.coderdot.controllers", "com.coderdot.configuration", "com.coderdot.services",
		"com.coderdot.filters", "com.coderdot.utils", "com.coderdot.mappers" })

public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}

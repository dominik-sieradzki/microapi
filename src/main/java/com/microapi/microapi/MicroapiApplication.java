package com.microapi.microapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.microapi.microapi")
@EnableJpaRepositories(basePackages = "com.microapi.microapi.OrderRecord")
@EnableTransactionManagement
public class MicroapiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroapiApplication.class, args);
	}

}

package com.edu.bankingservice.bankingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class BankingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingServiceApplication.class, args);
	}
}

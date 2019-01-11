package com.meriame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.meriame.service.AgentService;



@SpringBootApplication
public class ClientEBankingProject3Application {

	public static void main(String[] args) {
		SpringApplication.run(ClientEBankingProject3Application.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(AgentService agentService) {
		return args -> {
			System.out.println("--- login ---");
			System.out.println(agentService.loginAgent());
			};
		}

}


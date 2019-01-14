package com.meriame;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.meriame.service.AgentService;
import com.meriame.wsdl.ClientSOAPDTO;
import com.meriame.wsdl.CompteSOAPDTO;
import com.meriame.wsdl.GetClientsResponse;



@SpringBootApplication
public class ClientEBankingProject3Application {

	public static void main(String[] args) {
		SpringApplication.run(ClientEBankingProject3Application.class, args);
	}
	
	
	/*
	 * @Bean
	 * CommandLineRunner lookup(AgentService agentService) {
	 
		return args -> {
			System.out.println("--- login ---");
			System.out.println(agentService.loginAgent());
			System.out.println("--- clients---");
			System.out.println(agentService.getprofilagent().getEmail()
					);
			System.out.println("--- get all clients---");
			List<ClientSOAPDTO> getclients=agentService.getClients();
			System.out.println(getclients);
			getclients.stream().forEach(e->System.out.println("clients "+e.getUsername()
				));
			/*System.out.println("--- add clients---");
			System.out.println(agentService.addclient());
			System.out.println("--- edit clients---");
			System.out.println(agentService.editclient());*/
			/*System.out.println("--- delete clients---");
			System.out.println(agentService.deleteclient());
			System.out.println("--- add comptes---");
			System.out.println(agentService.addCompte());
			System.out.println("--- delete clients---");
			System.out.println(agentService.deleteclient());
			System.out.println("--- get all clients---");
		
			System.out.println(getclients);
			getclients.stream().forEach(e->System.out.println("clients "+e.getUsername()
				));
			List<CompteSOAPDTO> getcomptes=agentService.getComptes();
			System.out.println("--- get all comptes---");
			
			System.out.println(getcomptes);
			getcomptes.stream().forEach(e->System.out.println("comptes "+e.getSolde()
				));
			};
		}*/

	

}


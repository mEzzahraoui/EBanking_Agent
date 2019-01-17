package com.meriame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.meriame.service.AdminClient;
import com.meriame.service.AgentService;

@Configuration
public class WSConfigClient {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.meriame.wsdl");
		return marshaller;
	}
	
	
	@Bean
	public AgentService agentService(Jaxb2Marshaller marshaller) {
		AgentService agentServ=new AgentService();
		agentServ.setDefaultUri("https://g-bank.herokuapp.com/services/AgentService?wsdl");
		agentServ.setMarshaller(marshaller);
		agentServ.setUnmarshaller(marshaller);
		return agentServ;
	}
}

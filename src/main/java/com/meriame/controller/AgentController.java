package com.meriame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meriame.service.AgentService;

@RestController
public class AgentController {
	@Autowired
	AgentService agentService;
	
	
}

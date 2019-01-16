package com.meriame.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import com.meriame.modal.LoginForm;
import com.meriame.service.AgentService;
import com.meriame.wsdl.*;

@Controller
public class AgentController {
	@Autowired
	AgentService agentService;

	HttpSession session;
	@GetMapping("/")
	public String getFormLogin(LoginForm loginForm) {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String FormLogin(@Valid LoginForm loginForm,Model model) {
		
		String username=loginForm.getUsername();
		String password=loginForm.getPassword();
		System.out.println(username);
		boolean result=agentService.loginAgent(username, password);
		if(result) {
			AgentSOAPDTO agent=agentService.getprofilagent(username);
			List<ClientSOAPDTO> clients=agentService.getClients(username);
			 model.addAttribute("agent", agent);
			 model.addAttribute("clients",clients);
			return "index";
		}
		//model.addAttribute("invalidCredentials",true);
		return "login";
	}
	@GetMapping("/index")
	public String getindex() {
		
		return "index";
	}
	@GetMapping("/index/{id}")
	public String getindexagent(@PathVariable("id") String id ,Model model) {
		AgentSOAPDTO agent=agentService.getprofilagent(id);
		 model.addAttribute("agent", agent);
		return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String showeditprofilForm(@PathVariable("id") String id,Model model) {
		AgentSOAPDTO agent=agentService.getprofilagent(id);
	     model.addAttribute("agent",agent);
	    return "updateAgent";
	}
	@GetMapping("/addcompte/{id}")
	public String showaddcompteForm(@Valid CompteSOAPDTO compte,@PathVariable("id") String id,Model model) {
		ClientSOAPDTO client=agentService.getclient(id);
	     model.addAttribute("client",client);
	     model.addAttribute("compte", compte);
	     
	    return "AddCompte";
	}
	@GetMapping("/addClient/{id}")
	public String showaddclientForm( ClientSOAPDTO client,@PathVariable("id") String id,Model model) {
		AgentSOAPDTO agent=agentService.getprofilagent(id);
 	   model.addAttribute("agent",agent);
	     model.addAttribute("client",client);
	     
	     
	    return "AddClient";
	}
	@PostMapping("/addclient/{id}")
	public String AddUser( ClientSOAPDTO client,@PathVariable("id") String id,Model model) {
	
		ClientSOAPDTO c=agentService.addclient(client, id);
	       
	       if(c!=null) {
	    	   AgentSOAPDTO agent=agentService.getprofilagent(id);
	    	   model.addAttribute("agent",agent);
	    	   return  getindexagent(id ,model);
	       }
	               
	        return "clients";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") String id,  AgentSOAPDTO agent, Model model) {
	   
		boolean result=agentService.updateprofilAgent(agent, id);
	       
	       if(result) {
	    	    agent=agentService.getprofilagent(id);
	    	   model.addAttribute("agent",agent);
	    	   return "index";
	       }
	               
	        return "updateAgent";
	}
	@PostMapping("/addcompteClient/{id}")
    public String addUser(@Valid CompteSOAPDTO compte, @PathVariable("id") String id, Model model) {
       boolean result=agentService.addCompte(compte, id);
       
       if(result) {
    	   List<CompteSOAPDTO> comptes=agentService.getComptes(id);
    	   model.addAttribute("comptes", comptes);
    	   return "comptes";
       }
               
        return "index";
    }
	@GetMapping("/clients/{id}")
	public String showclientForm(@PathVariable("id") String id,Model model) {
		AgentSOAPDTO agent=agentService.getprofilagent(id);
		List<ClientSOAPDTO> clients=agentService.getClients(id);
		 model.addAttribute("agent", agent);
	     model.addAttribute("clients", clients);
	    return "clients";
	}
	
	
	@GetMapping("/compte/{id}")
	public String showcompteForm(@PathVariable("id") String id, Model model) {
		List<CompteSOAPDTO> comptes=agentService.getComptes(id);
		ClientSOAPDTO client=agentService.getclient(id);
		model.addAttribute("client", client);
	     model.addAttribute("comptes", comptes);
	    return "comptes";
	}
	@GetMapping("/activation/{id}")
	public String showactivationForm(@PathVariable("id") long id, Model model) {
		boolean etat=agentService.activateCompte(id);
		CompteSOAPDTO comptes=agentService.getcompte(id);
		model.addAttribute("comptes", comptes);
	     model.addAttribute("etat", etat);
	    return "comptes";
	}
	@GetMapping("/desactivation/{id}")
	public String showdesactivationForm(@PathVariable("id") long id, Model model) {
		boolean etat=agentService.desactivateCompte(id);
		CompteSOAPDTO comptes=agentService.getcompte(id);
		model.addAttribute("comptes", comptes);
	     model.addAttribute("etat", etat);
	    return "comptes";
	}
}

package com.meriame.service;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.namespace.QName;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.meriame.wsdl.*;

public class AgentService extends WebServiceGatewaySupport {
	
	
	ObjectFactory objFactory = new ObjectFactory();
	//******Agent********
	
	public boolean loginAgent(String username, String password) {
		
		AgentLogin request=(AgentLogin)objFactory.createAgentLogin();
		request.setArg0(username);
		request.setArg1(password);
		
		AgentLoginResponse resp=(AgentLoginResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
				.marshalSendAndReceive(
						new JAXBElement<AgentLogin>(new QName("http://soapService.meriame.com/", "agentLogin"),AgentLogin.class,request)));
				//uri : http://g-bank.herokuapp.com:8055/services/AgentService?wsdl
		return resp.isReturn();
		
	}
	
	 public AgentSOAPDTO getprofilagent(String username) {
		 
		 GetProfilAgent req=(GetProfilAgent)objFactory.createGetProfilAgent();
		 req.setArg0(username);
		 GetProfilAgentResponse resp=(GetProfilAgentResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
					.marshalSendAndReceive(
							new JAXBElement<GetProfilAgent>(new QName("http://soapService.meriame.com/", "getProfilAgent"),GetProfilAgent.class,req)));
					
		 
		return resp.getReturn();
		 
	 }
	 public boolean updateprofilAgent(AgentSOAPDTO agent, String username) {
		 UpdateAgent req=(UpdateAgent) objFactory.createUpdateAgent();	 
		 req.setArg0(agent);
		 req.setArg1(username);
		 UpdateAgentResponse resp=(UpdateAgentResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
					.marshalSendAndReceive(
							new JAXBElement<UpdateAgent>(new QName("http://soapService.meriame.com/", "updateAgent"),UpdateAgent.class,req)));
					
		 return resp.isReturn();
	 }
	//******Client********
	 
	 public List<ClientSOAPDTO> getClients(String usernameAgent){
		 
		 GetClients req=(GetClients)objFactory.createGetClients();
		 req.setArg0(usernameAgent);
		 GetClientsResponse resp=(GetClientsResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
					.marshalSendAndReceive(
							new JAXBElement<GetClients>(new QName("http://soapService.meriame.com/", "getClients"),GetClients.class,req)));
					
		 List<ClientSOAPDTO> clients=resp.getReturn();
		 return clients;
	 }
	 
	 public ClientSOAPDTO addclient(ClientSOAPDTO client,String usernameAgent) {
		 AddClient req=(AddClient) objFactory.createAddClient();
		 req.setArg0(client);
		 req.setArg1(usernameAgent);
		 AddClientResponse resp=(AddClientResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
					.marshalSendAndReceive(
							new JAXBElement<AddClient>(new QName("http://soapService.meriame.com/", "addClient"),AddClient.class,req)));
				
		 return resp.getReturn();
		 

	 }
	 public ClientSOAPDTO getclient(String cin) {
		Getclient req=(Getclient) objFactory.createGetclient();
		 req.setArg0(cin);
		 
		 GetclientResponse resp=(GetclientResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
					.marshalSendAndReceive(
							new JAXBElement<Getclient>(new QName("http://soapService.meriame.com/", "getclient"),Getclient.class,req)));
				
		 return resp.getReturn();
		 

	 }
	 public ClientSOAPDTO editclient(ClientSOAPDTO client,String usernameAgent) {
		 EditClient req=(EditClient) objFactory.createEditClient();
		 req.setArg0(client);
		 req.setArg1(usernameAgent);
		 EditClientResponse resp=(EditClientResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
					.marshalSendAndReceive(
							new JAXBElement<EditClient>(new QName("http://soapService.meriame.com/", "editClient"),EditClient.class,req)));
				
		 return resp.getReturn();
		 

	 }
	 public boolean deleteclient(String username) {
		 DeleteClient req=(DeleteClient) objFactory.createDeleteClient();
		 req.setArg0(username);
		 DeleteClientResponse resp=(DeleteClientResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
					.marshalSendAndReceive(
							new JAXBElement<DeleteClient>(new QName("http://soapService.meriame.com/", "deleteClient"),DeleteClient.class,req)));
				
		 return resp.isReturn();
	 }
	 
	//******Compte********
	 public List<CompteSOAPDTO> getComptes(String cin){
		 
		 GetCompteClient req=(GetCompteClient)objFactory.createGetCompteClient();
		 req.setArg0(cin);
		 GetCompteClientResponse resp=(GetCompteClientResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
					.marshalSendAndReceive(
							new JAXBElement<GetCompteClient>(new QName("http://soapService.meriame.com/", "getCompteClient"),GetCompteClient.class,req)));
				
		 
		 List<CompteSOAPDTO> comptes=resp.getReturn();
		 return comptes;
	 }
	 
	public boolean addCompte(CompteSOAPDTO compte,String cinClient) {
		
		AddCompte req= (AddCompte)objFactory.createAddCompte();
		req.setArg0(compte);
		req.setArg1(cinClient);
		AddCompteResponse resp=(AddCompteResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
					.marshalSendAndReceive(
							new JAXBElement<AddCompte>(new QName("http://soapService.meriame.com/", "addCompte"),AddCompte.class,req)));
				
		
		return resp.isReturn();
	}
	public boolean editCompte(CompteSOAPDTO compte) {
		
		EditCompte req=(EditCompte)objFactory.createEditCompte();
		req.setArg0(compte);
		EditCompteResponse resp=(EditCompteResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
				.marshalSendAndReceive(
						new JAXBElement<EditCompte>(new QName("http://soapService.meriame.com/", "editCompte"),EditCompte.class,req)));
			
	
		return resp.isReturn();
	}
	public boolean deleteCompte(Long id) {
		
		DeleteCompte req= (DeleteCompte)objFactory.createDeleteCompte();
		req.setArg0(id);
		
		DeleteCompteResponse resp=(DeleteCompteResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
				.marshalSendAndReceive(
						new JAXBElement<DeleteCompte>(new QName("http://soapService.meriame.com/", "deleteCompte"),DeleteCompte.class,req)));
			
		
		return resp.isReturn();
	}
	
	public boolean activateCompte(Long id) {
		
		ActivateCompte req= (ActivateCompte)objFactory.createActivateCompte();
		req.setArg0(id);
		
		ActivateCompteResponse resp=(ActivateCompteResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
				.marshalSendAndReceive(
						new JAXBElement<ActivateCompte>(new QName("http://soapService.meriame.com/", "activateCompte"),ActivateCompte.class,req)));
			
		return resp.isReturn();
	}
	public boolean desactivateCompte(Long id) {
		
		DesactivateCompte req= (DesactivateCompte)objFactory.createDesactivateCompte();
		req.setArg0(id);
		
		DesactivateCompteResponse resp=(DesactivateCompteResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
				.marshalSendAndReceive(
						new JAXBElement<DesactivateCompte>(new QName("http://soapService.meriame.com/", "desactivateCompte"),DesactivateCompte.class,req)));
			
		return resp.isReturn();
	}
	
	public CompteSOAPDTO getcompte(Long id) {
		
		GetCompte req= (GetCompte)objFactory.createGetCompte();
		req.setArg0(id);
		
		GetCompteResponse resp=(GetCompteResponse)JAXBIntrospector.getValue(getWebServiceTemplate()
				.marshalSendAndReceive(
						new JAXBElement<GetCompte>(new QName("http://soapService.meriame.com/", "getCompte"),GetCompte.class,req)));
			
		return resp.getReturn();
	}
	
}

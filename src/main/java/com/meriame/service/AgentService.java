package com.meriame.service;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.meriame.wsdl.AgentLogin;
import com.meriame.wsdl.AgentLoginResponse;

public class AgentService extends WebServiceGatewaySupport {
	
	//test Login 
	public boolean loginAgent() {
		AgentLogin request=new AgentLogin();
		request.setArg0("admin");
		request.setArg1("1234");
		JAXBElement<AgentLoginResponse> response = (JAXBElement<AgentLoginResponse>) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(""));
		AgentLoginResponse resp = response.getValue();
		return resp.isReturn();
	}
	
}

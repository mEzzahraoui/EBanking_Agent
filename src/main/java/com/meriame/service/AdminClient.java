package com.meriame.service;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class AdminClient extends WebServiceGatewaySupport  {
	
	/*public ListAdminResponse GetAllAdminsResponse() {
		
		ListAdmin request=new ListAdmin();
		JAXBElement<ListAdminResponse> response = (JAXBElement<ListAdminResponse>) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(""));
		return response.getValue();
		
	}*/

}

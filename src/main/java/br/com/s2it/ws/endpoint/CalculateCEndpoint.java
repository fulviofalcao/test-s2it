package br.com.s2it.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.s2it.service.CalculateCService;
import br.com.s2it.ws.CalculateCRequest;
import br.com.s2it.ws.CalculateCResponse;

@Endpoint
@WebService
public class CalculateCEndpoint {
	
	@Autowired
	private CalculateCService calculateCService;

	private static final String NAMESPACE_URI = "http://s2it.com.br/ws";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "calculateCRequest")
	@ResponsePayload
	@WebMethod
	public CalculateCResponse  getCalculateC (@RequestPayload CalculateCRequest request) {
		return calculateCService.getCalculateC(request.getNumber1().intValue(), request.getNumber2().intValue());
	}
}

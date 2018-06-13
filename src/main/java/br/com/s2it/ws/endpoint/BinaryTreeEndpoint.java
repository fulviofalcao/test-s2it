package br.com.s2it.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.s2it.domain.BinaryTree;
import br.com.s2it.service.BinaryTreeService;
import br.com.s2it.ws.BinaryTreeResponse;

@Endpoint
@WebService
public class BinaryTreeEndpoint {
	
	@Autowired
	private BinaryTreeService binaryTreeService;
	
private static final String NAMESPACE_URI = "http://s2it.com.br/ws";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "binaryTreeRequest")
	@ResponsePayload
	@WebMethod
	public BinaryTreeResponse  getCalculateC (@RequestBody BinaryTree binaryTree, @PathVariable Integer node) {
		return binaryTreeService.getSumBinaryTree(binaryTree, node);
	}

}

package br.com.s2it.resource;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.s2it.domain.BinaryTree;
import br.com.s2it.service.BinaryTreeService;
import br.com.s2it.util.GenericResponse;
import br.com.s2it.ws.BinaryTreeResponse;

@RestController
@RequestMapping("/api")
public class BinaryTreeResource {
	
	private final Logger log = LoggerFactory.getLogger(BinaryTreeResource.class);
	
	@Autowired
	private BinaryTreeService service;
	
	@RequestMapping(value = "/sunbinarytree", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> sunbinarytree(@RequestBody BinaryTree binaryTree, @PathVariable Integer node) {
		log.info("REST request to get SunBinaryTree : {}");
		
		BinaryTreeResponse binaryTreeResponse = service.getSumBinaryTree(binaryTree, node);
		
		return Optional.ofNullable(binaryTreeResponse).map(result -> new ResponseEntity<>(GenericResponse.ok(result), HttpStatus.OK))
				.orElse(new ResponseEntity<>(GenericResponse.error(), HttpStatus.NOT_FOUND));
	}

}

package br.com.s2it.resource;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.s2it.service.CalculateCService;
import br.com.s2it.util.GenericResponse;
import br.com.s2it.ws.CalculateCResponse;

@RestController
@RequestMapping("/api")
public class CalculateCResource {
	private final Logger log = LoggerFactory.getLogger(CalculateCResource.class);
	
	@Autowired
	private CalculateCService service;
	
	@RequestMapping(value = "/calculatec/{number1}/{number2}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> calculatec(@PathVariable Integer number1, @PathVariable Integer number2) {
		log.info("REST request to get CalculateC : {}");
		
		CalculateCResponse genericResponse = service.getCalculateC(number1, number2);
		
		return Optional.ofNullable(genericResponse).map(result -> new ResponseEntity<>(GenericResponse.ok(result), HttpStatus.OK))
				.orElse(new ResponseEntity<>(GenericResponse.error(), HttpStatus.NOT_FOUND));
	}
}

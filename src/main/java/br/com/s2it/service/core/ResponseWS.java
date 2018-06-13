package br.com.s2it.service.core;

import lombok.Getter;
import lombok.Setter;

public class ResponseWS {

	@Getter @Setter
	private int code;
	@Getter @Setter
	private String status;
	@Getter @Setter
	private Object result;
	
}

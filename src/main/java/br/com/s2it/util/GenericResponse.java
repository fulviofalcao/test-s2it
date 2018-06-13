package br.com.s2it.util;

import org.springframework.http.HttpStatus;

public class GenericResponse {

	private int code;
	private String status;
	private Object result;

	public GenericResponse(int code, String status) {
		super();
		this.code = code;
		this.status = status;
	}
	
	public GenericResponse(int code, String status, Object result) {
		super();
		this.code = code;
		this.status = status;
		this.result = result;
	}

	public static GenericResponse error() {
		return new GenericResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
	}
	
	public static GenericResponse ok(Object result) {
		return new GenericResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
	}
	
	public static GenericResponse ok() {
		return new GenericResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}

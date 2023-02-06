package com.miranda.cursos.exception;

public class ServiceJdbcException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public ServiceJdbcException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceJdbcException(String message) {
		super(message);
	}
	
	

}

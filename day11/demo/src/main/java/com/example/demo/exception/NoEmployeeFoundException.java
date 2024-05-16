package com.example.demo.exception;

public class NoEmployeeFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public NoEmployeeFoundException(String message) {
		super(message);
	}

}

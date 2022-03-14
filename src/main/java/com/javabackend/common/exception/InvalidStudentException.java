package com.javabackend.common.exception;

public class InvalidStudentException extends RuntimeException {
	
	public InvalidStudentException() {
		super();
	}
	
	public InvalidStudentException(String message) {
		super(message);
	}
	
	public InvalidStudentException(String message, Throwable throwable) {
		super(message, throwable);
	}
}

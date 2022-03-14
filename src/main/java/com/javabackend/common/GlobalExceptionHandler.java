package com.javabackend.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javabackend.common.exception.InvalidStudentException;
import com.javabackend.common.exception.NotFoundException;
import com.javabackend.common.exception.ResourceRuntimeException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {NotFoundException.class})
	public Object handleNotFoundException(NotFoundException e) {
		log.debug("ERROR CATCHED: {}", e);
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {ResourceRuntimeException.class})
	public Object handleGiraRuntimeException(ResourceRuntimeException e) {
		log.debug("ResourceRuntimeException: {}", e.getMessage());
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public Object handleUnexpectedException(Exception e) {
		log.error("Error has been occurred ====> {}", e);
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidStudentException.class)
	public Object handlInvalidRoleException(InvalidStudentException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}

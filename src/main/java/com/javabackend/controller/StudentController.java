package com.javabackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javabackend.model.Student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface StudentController {
	
	@Operation(method = "get", description = "get all students")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "get all students successfully"),
		@ApiResponse(responseCode = "403", description = "do not have the correct authorization")
	})
	@GetMapping(value = "/students", produces = "application/json")
	public ResponseEntity<Object> getStudents();
	
	@Operation(method = "post", description = "create new student")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "create student successfully"),
		@ApiResponse(responseCode = "400", description = "invalid student")
	})
	@PostMapping(value = "/student", produces = "application/json")
	public ResponseEntity<Object> createStudent(@RequestBody Student student, BindingResult bindingResult);
	
	@Operation(method = "put", description = "update student")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "update student successfully"),
		@ApiResponse(responseCode = "400", description = "invalid student")
	})
	@PutMapping(value = "/student/{id}", produces = "application/json")
	public ResponseEntity<Object> updateStudent(@PathVariable("id") long id, @RequestBody Student student,
			BindingResult bindingResult);
	
	@Operation(method = "put", description = "update student")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "update student successfully"),
		@ApiResponse(responseCode = "400", description = "invalid student")
	})
	@DeleteMapping(value = "/student/{id}", produces = "application/json")
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") long id);
	
}

package com.javabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.javabackend.common.ResponseHandler;
import com.javabackend.model.Student;
import com.javabackend.service.StudentService;

@RestController("/api")
public class StudentControllerImpl implements StudentController {

	private StudentService service;
	
	public StudentControllerImpl(StudentService service) {
		this.service = service;
	}
	
	@Override
	public ResponseEntity<Object> getStudents() {
		List<Student> students = service.findAllStudents();
		return ResponseHandler.getResponse(students, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createStudent(Student student, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		Student createdStudent = service.create(student);
		
		return ResponseHandler.getResponse(createdStudent, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Object> updateStudent(long id, Student student,  BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		Student updatedStudent = service.updateStudent(id, student);
		
		return ResponseHandler.getResponse(updatedStudent, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteStudent(long id) {
		service.deleteStudent(id);
		return ResponseHandler.getResponse(HttpStatus.OK);
	}


}

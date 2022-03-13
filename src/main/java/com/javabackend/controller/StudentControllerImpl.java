package com.javabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createStudent(Student student) {
		Student createdStudent = service.create(student);
		return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Object> updateStudent(long id, Student student) {
		Student updatedStudent = service.updateStudent(id, student);
		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteStudent(long id) {
		service.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}

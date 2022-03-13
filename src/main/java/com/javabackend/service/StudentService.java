package com.javabackend.service;

import java.util.List;

import com.javabackend.model.Student;

public interface StudentService {

	List<Student> findAllStudents();

	Student create(Student student);

	Student updateStudent(long id, Student student);

	void deleteStudent(long id);

}

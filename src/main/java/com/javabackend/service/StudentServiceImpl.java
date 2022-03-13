package com.javabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javabackend.model.Student;
import com.javabackend.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repository;
	
	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Student> findAllStudents() {
		return repository.findAll();
	}

	@Override
	public Student create(Student student) {
		return repository.save(student);
	}

	@Override
	public Student updateStudent(long id, Student student) {
		Optional<Student> studentOpt = repository.findById(id);
		
		Student updateStudent = studentOpt.get();
		
		updateStudent.setFullname(student.getFullname());
		updateStudent.setCode(student.getCode());
		updateStudent.setAddress(student.getAddress());
		updateStudent.setEmail(student.getEmail());
		updateStudent.setPhoneNum(student.getPhoneNum());
		return repository.save(updateStudent);
	}

	@Override
	public void deleteStudent(long id) {
		Optional<Student> studentOpt = repository.findById(id);
		
		Student deleteStudent = studentOpt.get();
		
		repository.delete(deleteStudent);
		
	}

}

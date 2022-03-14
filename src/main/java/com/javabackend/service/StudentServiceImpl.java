package com.javabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javabackend.common.exception.InvalidStudentException;
import com.javabackend.common.exception.NotFoundException;
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
		List<Student> students = repository.findAll();
		
		if(students.isEmpty()) {
			throw new NotFoundException("List student null.");
		}
		return students;
	}

	@Override
	public Student create(Student student) {
		
		List<Student> students = repository.findAll();
		
		for(Student stud : students) {
			if(student.getCode().equals(stud.getCode()) || student.getEmail().equals(stud.getEmail())) {
				throw new InvalidStudentException("Student code or student email have been used.");
			}
		}
		
		return repository.save(student);
	}

	@Override
	public Student updateStudent(long id, Student student) {
		Optional<Student> studentOpt = repository.findById(id);
		
		if(!studentOpt.isPresent())
			throw new InvalidStudentException("Student id is not valid.");
		
		Student updateStudent = studentOpt.get();
		
		if(!updateStudent.getEmail().equals(student.getEmail())) {
			if(repository.findByEmail(student.getEmail()).isPresent()) {
				throw new InvalidStudentException("Student email has been used");
			}
			updateStudent.setEmail(student.getEmail());
		}
		
		if(!updateStudent.getCode().equals(student.getCode())) {
			if(repository.findByCode(student.getCode()).isPresent()) {
				throw new InvalidStudentException("Student code has been used");
			}
			updateStudent.setCode(student.getCode());
		}
		
		if(!updateStudent.getPhoneNum().equals(student.getPhoneNum())) {
			if(repository.findByPhoneNum(student.getPhoneNum()).isPresent()) {
				throw new InvalidStudentException("Student phone number has been used.");
			}
			updateStudent.setPhoneNum(student.getPhoneNum());
		}
		
		updateStudent.setFullname(student.getFullname());
		updateStudent.setAddress(student.getAddress());
		
		return repository.save(updateStudent);
	}

	@Override
	public void deleteStudent(long id) {
		Optional<Student> studentOpt = repository.findById(id);
		
		if(!studentOpt.isPresent())
			throw new InvalidStudentException("Student ID is not existed.");
		
		Student deleteStudent = studentOpt.get();
		
		repository.delete(deleteStudent);
		
	}

}

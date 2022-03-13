package com.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javabackend.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

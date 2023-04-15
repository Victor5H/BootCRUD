package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;

	@Transactional
	public void insertStudent(Student s) {
		repository.save(s);
	}

	public void deleteStudent(int id) {
		repository.delete(null);
	}

	public Student getStudent(int id) {
		return repository.findById(id).get();
	}

	public List<Student> listAll() {
		return (List<Student>) repository.findAll();
	}
}

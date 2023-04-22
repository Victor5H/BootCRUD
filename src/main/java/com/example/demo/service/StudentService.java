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
	public Student insertStudent(Student s) {
		return repository.save(s);
	}

	@Transactional
	public boolean deleteStudent(int id) {
		repository.deleteById(id);
		if (getStudent(id) == null) {
			return true;
		}
		return false;
	}

	public Student getStudent(int id) {
		Student student = null;
		try {
			student = repository.findById(id).get();
		} catch (Exception e) {

		}
		return student;

	}

	public List<Student> listAll() {
		return (List<Student>) repository.findAll();
	}

	@Transactional
	public Student updateStudent(Student s) {
		return repository.save(s);
	}
}

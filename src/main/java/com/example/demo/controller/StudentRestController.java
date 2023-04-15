package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController

public class StudentRestController {
	@Autowired
	StudentService service;

	@GetMapping(path = "students")
	public List<Student> getStudents() {
		return service.listAll();
	}

	@PostMapping(path = "student/create")
	public Student createStudent(@RequestBody Student s) {
		return service.insertStudent(s);
	}

	@PutMapping(path = "student/update")
	public Student updateStudent(@RequestBody Student s) {
		return service.updateStudent(s);
	}

	@GetMapping(path = "student/{id}")
	public Student getStudent(@PathVariable int id) {
		return service.getStudent(id);
	}

	@DeleteMapping(path = "student/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
	}

}

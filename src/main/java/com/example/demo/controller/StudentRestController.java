package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> list = service.listAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping(path = "student/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student s) {
		Student student = service.insertStudent(s);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(student);
	}

	@PutMapping(path = "student/update/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student s, @PathVariable int id) {
		s.setId(id);
		Student student = service.updateStudent(s);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	@GetMapping(path = "student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) {
		Student student = service.getStudent(id);
		if (student == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(null);
	}

	@DeleteMapping(path = "student/delete/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
		boolean flag = service.deleteStudent(id);
		if (flag) {
			return ResponseEntity.ok().build();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

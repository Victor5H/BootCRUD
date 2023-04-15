package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@SpringBootApplication
public class StudentCrudApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentCrudApplication.class, args);
		StudentService service = context.getBean(StudentService.class);
		service.insertStudent(new Student("Harshit", 5.8));
		System.out.println(service.listAll());
	}

}

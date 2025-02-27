package com.charan.spring_security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.charan.spring_security.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	List<Student> students = new ArrayList<>(
			List.of(new Student(1, "Charan", "CSE"), new Student(2, "Narasimha", "MCA")));

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}

	@PostMapping("/students")
	public void addStudents(@RequestBody Student student) {
		students.add(student);
	}

}

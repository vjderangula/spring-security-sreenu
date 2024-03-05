package com.sreenu.springsecuritysreenu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sreenu.springsecuritysreenu.model.Student;

@RestController
public class StudentController {
	
	
	List<Student> listStudent= new ArrayList<>();
	
	@GetMapping("/student")
	public List<Student> students(){
				
		Student student = new Student();
		student.setId(1);
		student.setFirstName("sreenu");
		student.setLastName("Derangula");

		Student student1 = new Student();
		student1.setId(2);
		student1.setFirstName("Kala");
		student1.setLastName("Derangula");
		
		listStudent.add(student);
		listStudent.add(student1);
		
		
		return listStudent;
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/createt")
	public Student createStudents(@RequestBody Student student){
		//Student studentData = new Student();
		listStudent.add(student);
		return student;
	}
				

}

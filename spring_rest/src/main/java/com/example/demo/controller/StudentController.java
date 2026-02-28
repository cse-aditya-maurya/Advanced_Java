package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService; 

@RestController
public class StudentController {
	private StudentService studentService;
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
	}
	@RequestMapping("/")
	public String message() {
		return "Welcome";
	}
	@GetMapping("/student")
	public List<Student> getStudents(){
		return studentService.getAllStudent();
	}
	@GetMapping("/student/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id){
		return studentService.getStudentById(id);
		
	}
	
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable Long id,
	                             @RequestBody Student student) {
	    return studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
	    studentService.deleteStudentById(id);
	    return "Student deleted successfully";
	}
	
	
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
		
	}
	

}

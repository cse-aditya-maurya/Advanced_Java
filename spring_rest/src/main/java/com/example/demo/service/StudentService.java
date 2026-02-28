package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.repository.StudentRepository;
import java.util.*;
import com.example.demo.model.Student;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
		
	}
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	
	
	public Optional<Student> getStudentById( Long id){
		return studentRepository.findById(id);
	}
	
	public Student updateStudent(Long id, Student student) {

	    student.setId(id);  
	    return studentRepository.save(student);
	}
	
	public void deleteStudentById(Long id) {
	    studentRepository.deleteById(id);
	}

}

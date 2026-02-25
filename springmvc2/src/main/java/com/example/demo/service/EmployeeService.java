package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.Employee;
import java.util.*;

@Service
public class EmployeeService {
	public EmployeeRepository empRepository;

	public EmployeeService(EmployeeRepository empRepository) {
		this.empRepository = empRepository;
	}
	public List<Employee> getAllEmployee(){
		return empRepository.findAll();
		
	}
	public void saveEmployee(Employee emp) {
		empRepository.save(emp);
		
	}
	
	

}

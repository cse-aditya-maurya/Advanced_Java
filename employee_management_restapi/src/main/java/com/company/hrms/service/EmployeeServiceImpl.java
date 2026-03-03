package com.company.hrms.service;

import com.company.hrms.dto.request.EmployeeRequestDTO;
import com.company.hrms.dto.response.EmployeeResponseDTO;
import com.company.hrms.entity.Department;
import com.company.hrms.entity.Employee;
import com.company.hrms.exception.EmployeeNotFoundException;
import com.company.hrms.exception.DepartmentNotFoundException;
import com.company.hrms.mapper.EmployeeMapper;
import com.company.hrms.repository.EmployeeRepository;
import com.company.hrms.repository.DepartmentRepository;
import com.company.hrms.service.EmployeeService;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository,
                               EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request) {

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found with id: " + request.getDepartmentId()));

        Employee employee = employeeMapper.toEntity(request);
        employee.setDepartment(department);

        Employee saved = employeeRepository.save(employee);

        return employeeMapper.toResponse(saved);
    }

    @Override
    public Page<EmployeeResponseDTO> getAllEmployees(String departmentName,
                                                     Double minSalary,
                                                     Double maxSalary,
                                                     int page,
                                                     int size,
                                                     String sortBy,
                                                     String direction) {

        Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Employee> employees = employeeRepository.findAll(pageable);

        return employees.map(employeeMapper::toResponse);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with id: " + id));

        return employeeMapper.toResponse(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO request) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with id: " + id));

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found with id: " + request.getDepartmentId()));

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setDepartment(department);

        Employee updated = employeeRepository.save(employee);

        return employeeMapper.toResponse(updated);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
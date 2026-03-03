package com.company.hrms.mapper;

import com.company.hrms.dto.request.EmployeeRequestDTO;
import com.company.hrms.dto.response.EmployeeResponseDTO;
import com.company.hrms.dto.response.DepartmentResponseDTO;
import com.company.hrms.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequestDTO dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());
        return employee;
    }

    public EmployeeResponseDTO toResponse(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();

        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setSalary(employee.getSalary());

        // Nested Department Mapping
        DepartmentResponseDTO departmentDTO = new DepartmentResponseDTO();
        departmentDTO.setId(employee.getDepartment().getId());
        departmentDTO.setName(employee.getDepartment().getName());
        departmentDTO.setLocation(employee.getDepartment().getLocation());

        dto.setDepartment(departmentDTO);

        return dto;
    }
}
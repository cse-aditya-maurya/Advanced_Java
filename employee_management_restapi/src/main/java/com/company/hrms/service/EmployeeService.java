package com.company.hrms.service;

import com.company.hrms.dto.request.EmployeeRequestDTO;
import com.company.hrms.dto.response.EmployeeResponseDTO;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO request);

    Page<EmployeeResponseDTO> getAllEmployees(
            String department,
            Double minSalary,
            Double maxSalary,
            int page,
            int size,
            String sortBy,
            String direction
    );

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO request);

    void deleteEmployee(Long id);
}
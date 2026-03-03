package com.company.hrms.service;

import com.company.hrms.dto.request.DepartmentRequestDTO;
import com.company.hrms.dto.response.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseDTO createDepartment(DepartmentRequestDTO request);

    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO getDepartmentById(Long id);
}
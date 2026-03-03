package com.company.hrms.mapper;

import com.company.hrms.dto.request.DepartmentRequestDTO;
import com.company.hrms.dto.response.DepartmentResponseDTO;
import com.company.hrms.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public Department toEntity(DepartmentRequestDTO dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setLocation(dto.getLocation());
        return department;
    }

    public DepartmentResponseDTO toResponse(Department department) {
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setLocation(department.getLocation());
        return dto;
    }
}
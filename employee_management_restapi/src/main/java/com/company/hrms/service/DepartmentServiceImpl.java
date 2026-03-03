package com.company.hrms.service;

import com.company.hrms.dto.request.DepartmentRequestDTO;
import com.company.hrms.dto.response.DepartmentResponseDTO;
import com.company.hrms.entity.Department;
import com.company.hrms.exception.DepartmentNotFoundException;
import com.company.hrms.mapper.DepartmentMapper;
import com.company.hrms.repository.DepartmentRepository;
import com.company.hrms.service.DepartmentService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
                                 DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO request) {
        Department department = departmentMapper.toEntity(request);
        Department saved = departmentRepository.save(department);
        return departmentMapper.toResponse(saved);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + id));

        return departmentMapper.toResponse(department);
    }
}
package com.company.hrms.controller;

import com.company.hrms.dto.request.DepartmentRequestDTO;
import com.company.hrms.dto.response.DepartmentResponseDTO;
import com.company.hrms.service.DepartmentService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // POST /api/departments
    @PostMapping
    public DepartmentResponseDTO createDepartment(
            @Valid @RequestBody DepartmentRequestDTO request) {
        return departmentService.createDepartment(request);
    }

    // GET /api/departments
    @GetMapping
    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // GET /api/departments/{id}
    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }
}
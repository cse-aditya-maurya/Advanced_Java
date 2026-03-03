package com.company.hrms.controller;

import com.company.hrms.dto.request.EmployeeRequestDTO;
import com.company.hrms.dto.response.EmployeeResponseDTO;
import com.company.hrms.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // POST /api/employees
    @PostMapping
    public EmployeeResponseDTO createEmployee(
            @Valid @RequestBody EmployeeRequestDTO request) {
        return employeeService.createEmployee(request);
    }

    // GET /api/employees
    @GetMapping
    public Page<EmployeeResponseDTO> getAllEmployees(
            @RequestParam(required = false) String department,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return employeeService.getAllEmployees(
                department,
                minSalary,
                maxSalary,
                page,
                size,
                sortBy,
                direction
        );
    }

    // GET /api/employees/{id}
    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // PUT /api/employees/{id}
    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO request) {
        return employeeService.updateEmployee(id, request);
    }

    // DELETE /api/employees/{id}
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
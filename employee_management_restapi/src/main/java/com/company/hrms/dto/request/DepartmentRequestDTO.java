package com.company.hrms.dto.request;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDTO {

    @NotBlank(message = "Department name cannot be blank")
    private String name;

    private String location;

    public DepartmentRequestDTO() {
    }

    public DepartmentRequestDTO(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
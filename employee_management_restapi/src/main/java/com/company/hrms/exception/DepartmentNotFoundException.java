package com.company.hrms.exception;

public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
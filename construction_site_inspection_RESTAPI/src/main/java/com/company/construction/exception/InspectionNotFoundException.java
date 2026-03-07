package com.company.construction.exception;

public class InspectionNotFoundException extends RuntimeException {

    public InspectionNotFoundException(String message) {
        super(message);
    }
}
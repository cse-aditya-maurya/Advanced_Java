package com.company.construction.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class InspectionCreateRequestDTO {

    @NotBlank(message = "Site name is required")
    private String siteName;

    @NotBlank(message = "Inspector name is required")
    private String inspectorName;

    @NotNull(message = "Inspection date is required")
    private LocalDate inspectionDate;

    private String remarks;

    public InspectionCreateRequestDTO() {
    }

    public String getSiteName() {
        return siteName;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
package com.company.construction.dto;

import java.time.LocalDate;

public class InspectionResponseDTO {

    private Long id;
    private String siteName;
    private String inspectorName;
    private LocalDate inspectionDate;
    private String remarks;
    private String photoFileName;
    private String reportFileName;

    public InspectionResponseDTO() {
    }

    public InspectionResponseDTO(Long id, String siteName, String inspectorName,
                                 LocalDate inspectionDate, String remarks,
                                 String photoFileName, String reportFileName) {
        this.id = id;
        this.siteName = siteName;
        this.inspectorName = inspectorName;
        this.inspectionDate = inspectionDate;
        this.remarks = remarks;
        this.photoFileName = photoFileName;
        this.reportFileName = reportFileName;
    }

    public Long getId() {
        return id;
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

    public String getPhotoFileName() {
        return photoFileName;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }
}
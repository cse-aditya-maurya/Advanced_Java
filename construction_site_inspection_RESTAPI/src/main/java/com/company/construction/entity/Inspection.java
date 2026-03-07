package com.company.construction.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inspections")
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String siteName;

    @Column(nullable = false)
    private String inspectorName;

    @Column(nullable = false)
    private LocalDate inspectionDate;

    @Column(length = 1000)
    private String remarks;

    // Only file names stored (NOT file bytes)
    @Column(nullable = false)
    private String photoFileName;

    @Column(nullable = false)
    private String reportFileName;

    // Constructors
    public Inspection() {
    }

    public Inspection(Long id, String siteName, String inspectorName,
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

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }
    
    
    
    
    
    
}
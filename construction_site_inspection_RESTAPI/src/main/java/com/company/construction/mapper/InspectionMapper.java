package com.company.construction.mapper;

import com.company.construction.dto.InspectionResponseDTO;
import com.company.construction.entity.Inspection;
import org.springframework.stereotype.Component;

@Component
public class InspectionMapper {

    public InspectionResponseDTO toDTO(Inspection inspection) {

        InspectionResponseDTO dto = new InspectionResponseDTO();

        dto.setId(inspection.getId());
        dto.setSiteName(inspection.getSiteName());
        dto.setInspectorName(inspection.getInspectorName());
        dto.setInspectionDate(inspection.getInspectionDate());
        dto.setRemarks(inspection.getRemarks());
        dto.setPhotoFileName(inspection.getPhotoFileName());
        dto.setReportFileName(inspection.getReportFileName());

        return dto;
    }

    public Inspection toEntity(String siteName,
                               String inspectorName,
                               java.time.LocalDate inspectionDate,
                               String remarks,
                               String photoFileName,
                               String reportFileName) {

        Inspection inspection = new Inspection();

        inspection.setSiteName(siteName);
        inspection.setInspectorName(inspectorName);
        inspection.setInspectionDate(inspectionDate);
        inspection.setRemarks(remarks);
        inspection.setPhotoFileName(photoFileName);
        inspection.setReportFileName(reportFileName);

        return inspection;
    }
}
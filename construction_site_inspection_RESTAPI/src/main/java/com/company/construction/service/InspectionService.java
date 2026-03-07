package com.company.construction.service;

import com.company.construction.dto.InspectionResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public interface InspectionService {

    InspectionResponseDTO createInspection(
            String siteName,
            String inspectorName,
            LocalDate inspectionDate,
            String remarks,
            MultipartFile sitePhoto,
            MultipartFile safetyReport
    );

    InspectionResponseDTO getInspectionById(Long id);

    byte[] downloadPhoto(Long id);

    byte[] downloadReport(Long id);
}
package com.company.construction.service.impl;

import com.company.construction.dto.InspectionResponseDTO;
import com.company.construction.entity.Inspection;
import com.company.construction.exception.FileStorageException;
import com.company.construction.exception.InspectionNotFoundException;
import com.company.construction.mapper.InspectionMapper;
import com.company.construction.repository.InspectionRepository;
import com.company.construction.service.InspectionService;
import com.company.construction.util.FileStorageUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

@Service
public class InspectionServiceImpl implements InspectionService {

    private final InspectionRepository repository;
    private final InspectionMapper mapper;
    private final FileStorageUtil fileStorageUtil;

    public InspectionServiceImpl(InspectionRepository repository,
                                 InspectionMapper mapper,
                                 FileStorageUtil fileStorageUtil) {
        this.repository = repository;
        this.mapper = mapper;
        this.fileStorageUtil = fileStorageUtil;
    }

    @Override
    public InspectionResponseDTO createInspection(
            String siteName,
            String inspectorName,
            LocalDate inspectionDate,
            String remarks,
            MultipartFile sitePhoto,
            MultipartFile safetyReport) {

        validateFiles(sitePhoto, safetyReport);

        // Save entity first (without file names)
        Inspection inspection = new Inspection();
        inspection.setSiteName(siteName);
        inspection.setInspectorName(inspectorName);
        inspection.setInspectionDate(inspectionDate);
        inspection.setRemarks(remarks);

        Inspection savedInspection = repository.save(inspection);

        // Save files into folder
        String photoFileName = fileStorageUtil.saveFile(savedInspection.getId(), sitePhoto);
        String reportFileName = fileStorageUtil.saveFile(savedInspection.getId(), safetyReport);

        savedInspection.setPhotoFileName(photoFileName);
        savedInspection.setReportFileName(reportFileName);

        repository.save(savedInspection);

        return mapper.toDTO(savedInspection);
    }

    @Override
    public InspectionResponseDTO getInspectionById(Long id) {

        Inspection inspection = repository.findById(id)
                .orElseThrow(() ->
                        new InspectionNotFoundException("Inspection not found with id: " + id));

        return mapper.toDTO(inspection);
    }

    @Override
    public byte[] downloadPhoto(Long id) {

        Inspection inspection = repository.findById(id)
                .orElseThrow(() ->
                        new InspectionNotFoundException("Inspection not found"));

        try {
            Path path = fileStorageUtil.getFilePath(id, inspection.getPhotoFileName());
            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new FileStorageException("Could not read photo file");
        }
    }

    @Override
    public byte[] downloadReport(Long id) {

        Inspection inspection = repository.findById(id)
                .orElseThrow(() ->
                        new InspectionNotFoundException("Inspection not found"));

        try {
            Path path = fileStorageUtil.getFilePath(id, inspection.getReportFileName());
            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new FileStorageException("Could not read report file");
        }
    }

    // ========================
    // FILE VALIDATION LOGIC
    // ========================
    private void validateFiles(MultipartFile photo, MultipartFile report) {

        if (photo.isEmpty() || report.isEmpty()) {
            throw new FileStorageException("Files must not be empty");
        }

        String photoType = photo.getContentType();
        String reportType = report.getContentType();

        if (!(photoType.equals("image/jpeg") || photoType.equals("image/png"))) {
            throw new FileStorageException("Photo must be JPG or PNG");
        }

        if (!reportType.equals("application/pdf")) {
            throw new FileStorageException("Safety report must be PDF");
        }

        if (photo.getSize() > 5 * 1024 * 1024 ||
            report.getSize() > 5 * 1024 * 1024) {
            throw new FileStorageException("File size must not exceed 5MB");
        }
    }
}
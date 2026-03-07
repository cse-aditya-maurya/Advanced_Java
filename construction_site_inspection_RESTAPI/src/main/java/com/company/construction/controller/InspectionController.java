package com.company.construction.controller;

import com.company.construction.dto.InspectionResponseDTO;
import com.company.construction.service.InspectionService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/inspections")
public class InspectionController {

    private final InspectionService service;

    public InspectionController(InspectionService service) {
        this.service = service;
    }

    // =========================================
    // CREATE INSPECTION (MULTIPART)
    // =========================================
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<InspectionResponseDTO> createInspection(

            @RequestParam @NotBlank String siteName,
            @RequestParam @NotBlank String inspectorName,
            @RequestParam @NotNull LocalDate inspectionDate,
            @RequestParam(required = false) String remarks,
            @RequestParam MultipartFile sitePhoto,
            @RequestParam MultipartFile safetyReport
    ) {

        InspectionResponseDTO response = service.createInspection(
                siteName,
                inspectorName,
                inspectionDate,
                remarks,
                sitePhoto,
                safetyReport
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // =========================================
    // GET INSPECTION DETAILS
    // =========================================
    @GetMapping("/{id}")
    public ResponseEntity<InspectionResponseDTO> getInspection(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getInspectionById(id));
    }

    // =========================================
    // DOWNLOAD SITE PHOTO
    // =========================================
    @GetMapping("/{id}/photo")
    public ResponseEntity<ByteArrayResource> downloadPhoto(
            @PathVariable Long id) {

        byte[] data = service.downloadPhoto(id);

        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // will still work for png
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"site-photo.jpg\"")
                .body(resource);
    }

    // =========================================
    // DOWNLOAD SAFETY REPORT
    // =========================================
    @GetMapping("/{id}/report")
    public ResponseEntity<ByteArrayResource> downloadReport(
            @PathVariable Long id) {

        byte[] data = service.downloadReport(id);

        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"safety-report.pdf\"")
                .body(resource);
    }
}
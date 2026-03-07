package com.company.construction.util;

import com.company.construction.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Component
public class FileStorageUtil {

    @Value("${file.upload-dir:uploads/inspections}")
    private String baseUploadDir;

    // =========================================
    // SAVE FILE
    // =========================================
    public String saveFile(Long inspectionId, MultipartFile file) {

        try {

            // Clean file name to prevent path traversal
            String originalFileName = Paths.get(file.getOriginalFilename())
                                           .getFileName()
                                           .toString();

            if (originalFileName.contains("..")) {
                throw new FileStorageException("Invalid file name");
            }

            // Create directory: uploads/inspections/{id}/
            Path uploadPath = Paths.get(baseUploadDir, inspectionId.toString());
            Files.createDirectories(uploadPath);

            // Target file path
            Path targetLocation = uploadPath.resolve(originalFileName);

            // Copy file
            Files.copy(file.getInputStream(),
                    targetLocation,
                    StandardCopyOption.REPLACE_EXISTING);

            return originalFileName;

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file: " + ex.getMessage());
        }
    }

    // =========================================
    // GET FILE PATH (FOR DOWNLOAD)
    // =========================================
    public Path getFilePath(Long inspectionId, String fileName) {

        Path filePath = Paths.get(baseUploadDir,
                inspectionId.toString(),
                fileName);

        if (!Files.exists(filePath)) {
            throw new FileStorageException("File not found");
        }

        return filePath;
    }

    // =========================================
    // DELETE FILES (Optional Future Use)
    // =========================================
    public void deleteInspectionFolder(Long inspectionId) {

        Path folderPath = Paths.get(baseUploadDir, inspectionId.toString());

        try {
            if (Files.exists(folderPath)) {
                Files.walk(folderPath)
                        .sorted((a, b) -> b.compareTo(a)) // delete files first
                        .forEach(path -> {
                            try {
                                Files.delete(path);
                            } catch (IOException e) {
                                throw new FileStorageException("Could not delete file");
                            }
                        });
            }
        } catch (IOException e) {
            throw new FileStorageException("Error deleting inspection folder");
        }
    }
}
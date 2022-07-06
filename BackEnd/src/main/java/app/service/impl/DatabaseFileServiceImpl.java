package app.service.impl;

import app.entity.LicImage;
import app.entity.NicImage;
import app.exception.FileNotFoundException;
import app.exception.FileStorageException;
import app.repo.LicRepo;
import app.repo.NicRepo;
import app.service.DatabaseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class DatabaseFileServiceImpl implements DatabaseFileService {

    @Autowired
    private NicRepo nicRepo;

    @Autowired
    private LicRepo licRepo;




    @Override
    public NicImage saveNic(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            NicImage dbNicImage = new NicImage(fileName, file.getContentType(), file.getBytes());

            return nicRepo.save(dbNicImage);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public NicImage getNic(String fileId) {
        return nicRepo.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }

    @Override
    public LicImage saveLic(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            LicImage dbLicImage = new LicImage(fileName, file.getContentType(), file.getBytes());

            return licRepo.save(dbLicImage);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public LicImage getLic(String fileId) {
        return licRepo.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }
}

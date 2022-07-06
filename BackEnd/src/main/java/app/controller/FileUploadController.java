package app.controller;


import app.dto.LicImageDTO;
import app.dto.NicImageDTO;
import app.entity.LicImage;
import app.entity.NicImage;
import app.service.DatabaseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@CrossOrigin
public class FileUploadController {

    @Autowired
    private DatabaseFileService fileStorageService;

    @PostMapping("/uploadNic")
    public NicImageDTO uploadFile(@RequestParam("file") MultipartFile file) {
    	NicImage nicImageName = fileStorageService.saveNic(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(nicImageName.getFileName())
                .toUriString();

        return new NicImageDTO(nicImageName.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadLic")
    public LicImageDTO uploadLic(@RequestParam("file") MultipartFile file) {
        LicImage licImage = fileStorageService.saveLic(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(licImage.getFileName())
                .toUriString();

        return new LicImageDTO(licImage.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    /*@PostMapping("/uploadMultipleFiles")
    public List<NicImageDTO> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/
}

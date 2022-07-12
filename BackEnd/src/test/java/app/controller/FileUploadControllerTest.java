package app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/
@RestController
@RequestMapping("api/v1/uploadTest")
@CrossOrigin
class FileUploadControllerTest {
    private static final ArrayList<String> allImages = new ArrayList<>();

    @PostMapping
    @Test
    ResponseEntity uploadFile(@RequestPart("myFile") MultipartFile myFile) {
        try {
            //String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File projectPath = new File("C:/Users/Rajith Sanjaya/Desktop/");
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));

            //save the path of the uploaded image in the temporary database
            allImages.add("uploads/" + myFile.getOriginalFilename());

            return  ResponseEntity.ok(HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
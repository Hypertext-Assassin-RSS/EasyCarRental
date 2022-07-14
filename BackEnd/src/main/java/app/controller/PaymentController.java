package app.controller;

import app.service.DatabaseFileService;
import app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 14
 **/

@RestController
@RequestMapping("api/v1/Pay")
@CrossOrigin
public class PaymentController {

    @Autowired
    DatabaseFileService databaseFileService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil uploadPaymentProof(@RequestPart("file") MultipartFile[] files, String nicNo) throws IOException {
        for (MultipartFile file : files) {
            databaseFileService.uploadPaymentProof(file);

            File fileSavePath = new File("C:/Users/Rajith Sanjaya/Desktop/uploads/payments");
            File uploadsDir = new File(fileSavePath + "/" + nicNo);
            System.out.println(fileSavePath);
            uploadsDir.mkdir();
            file.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file.getOriginalFilename()));
        }
        return new ResponseUtil(200, "Nic No : " + nicNo + " Payment Proof Send Success", null);
    }
}

package app.controller;

import app.dto.CardDTO;
import app.entity.CarImages;
import app.service.CarService;
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
 * @Date 2022 Jul 11
 **/

@RestController
@CrossOrigin
@RequestMapping("api/v1/Car")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    DatabaseFileService databaseFileService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(CardDTO cardDTO){
        carService.saveCar(cardDTO);
        return new ResponseUtil(200,"Car : "+cardDTO.getRegistrationNumber()+" data Saved",null);
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadFiles(@RequestPart("files") MultipartFile[] files,String regNum) throws IOException {
        for (MultipartFile file:files) {
            CarImages carImages = databaseFileService.saveCarImage(file);

            File fileSavePath = new File("C:/Users/Rajith Sanjaya/Desktop/uploads/car");
            File uploadsDir = new File(fileSavePath + "/"+regNum);
            System.out.println(fileSavePath);
            uploadsDir.mkdir();
            file.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file.getOriginalFilename()));
        }
        return  new ResponseUtil(200,"File is Saved",null);
    }
}

package app.controller;

import app.dto.CarDTO;
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
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCars(){
        return new ResponseUtil(200,"Done",carService.getAllCars());
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(CarDTO carDTO){
        carService.saveCar(carDTO);
        return new ResponseUtil(200,"Car : "+ carDTO.getRegistrationNumber()+" data Saved",null);
    }


    @GetMapping(path = "/{registrationNumber}")
    public ResponseUtil searchCar(@PathVariable String registrationNumber){
        return new ResponseUtil(200,"Done",carService.searchCar(registrationNumber));
    }


    @DeleteMapping(params = {"registrationNumber"})
    public ResponseUtil deleteCar(@RequestParam String registrationNumber){
        carService.deleteCar(registrationNumber);
        return new ResponseUtil(200,"Car : "+registrationNumber+" is deleted",null);
    }


    @PostMapping(value = "/file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
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

package app.controller;

import app.dto.GustUserDTO;
import app.dto.AccountDTO;
import app.entity.CarImages;
import app.entity.LicImage;
import app.entity.NicImage;
import app.service.*;
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
 * @Date 2022 Jul 05
 **/

@RestController
@RequestMapping("api/v1/User")
@CrossOrigin
public class GustUserController {

    @Autowired
    GustUserService gustUserService;

    @Autowired
    AccountService accountService;

    @Autowired
    DatabaseFileService databaseFileService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    RentRequestService rentRequestService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil registerGustUser(@RequestBody GustUserDTO gustUserDTO){
        gustUserService.registerGustUser(gustUserDTO);
        return new ResponseUtil(200,"User : "+gustUserDTO.getId() +" saved successful!!",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllGustUsers(){
        return new ResponseUtil(200,"Get All User OK",gustUserService.getAllGustUsers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateGustUser(@RequestBody  GustUserDTO gustUserDTO){
        gustUserService.updateGustUser(gustUserDTO);
        return new ResponseUtil(200,"User ID :"+gustUserDTO.getId()+" Update Successful!!",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteGustUser(@RequestParam String id){
        gustUserService.deleteGustUser(id);
        return new ResponseUtil(200,"User ID :"+id+" Deleted!!!",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchGustUser(@PathVariable  String id){
        return new ResponseUtil(200,"Done",gustUserService.searchGustUser(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/nic",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil uploadNic(@RequestPart("nicFiles") MultipartFile[] files, String nicNo) throws IOException {
        for (MultipartFile file:files) {
            NicImage nicImage = databaseFileService.saveNic(file);

            File fileSavePath = new File("C:/Users/Rajith Sanjaya/Desktop/uploads/gust/nic");
            File uploadsDir = new File(fileSavePath + "/"+nicNo);
            System.out.println(fileSavePath);
            uploadsDir.mkdir();
            file.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file.getOriginalFilename()));
        }
        return  new ResponseUtil(200,"Nic No : "+nicNo+" image is Saved",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/lic",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadLic(@RequestPart("licFiles") MultipartFile[] files, String licNo) throws IOException {
        for (MultipartFile file:files) {
            LicImage licImage = databaseFileService.saveLic(file);

            File fileSavePath = new File("C:/Users/Rajith Sanjaya/Desktop/uploads/gust/lic");
            File uploadsDir = new File(fileSavePath + "/"+licNo);
            System.out.println(fileSavePath);
            uploadsDir.mkdir();
            file.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file.getOriginalFilename()));
        }
        return  new ResponseUtil(200,"Lic No : "+licNo+" image is Saved",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/rent",params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil checkRentRequestStatus(@RequestParam String id){
        return new ResponseUtil(200,"Your Rent Request Status : "+gustUserService.checkRequestStatus(id),null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/verification",params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil checkVerificationStatus(@RequestParam String id){
        return new ResponseUtil(200,"Your verification is " +gustUserService.checkVerificationStatus(id),null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/pay",params = {"id"})
    public ResponseUtil returnCar(@RequestParam String id){
        rentRequestService.carReturn(id);
        return  new ResponseUtil(200,"Return Request Success,Your WaiverPayment amount will release after car inspection done!",paymentService.calculateRentalPayment(id));
    }
}

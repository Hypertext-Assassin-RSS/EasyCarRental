package app.controller;

import app.dto.AccountDTO;
import app.dto.AdminDTO;
import app.service.*;
import app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/

@RestController
@CrossOrigin
@RequestMapping("api/v1/Admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    AccountService accountService;

    @Autowired
    RentRequestService rentRequestService;

    @Autowired
    GustUserService gustUserService;

    @Autowired
    PaymentService paymentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO adminDTO, @ModelAttribute AccountDTO accountDTO){
        adminService.saveAdmin(adminDTO);
        accountService.saveAccount(accountDTO);
        return new ResponseUtil(200,"Admin "+adminDTO.getName()+" data saved",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(@PathVariable String id){
        adminService.deleteAdmin(id);
        return  new ResponseUtil(200,"Admin ID : "+id+" data is deleted!!",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/rent",params = {"date"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findTodayRentRequests(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return  new ResponseUtil(200,"Done",rentRequestService.getRentRequestToday(date));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/user",params = {"date"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findRegisterUsersToday(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return new ResponseUtil(200,"Done",gustUserService.getAllUsersRegisterToday(date));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(params = {"requestCode","status"})
    public ResponseUtil changeRentRequestStatus(String requestCode,String status){
        rentRequestService.changeRentRequestStatus(requestCode, status);
        return  new ResponseUtil(200,"RentRequest : "+requestCode+" status changed",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(params = {"id","status"})
    public ResponseUtil changeVerificationStatus(@RequestParam String id,String status){
        gustUserService.changeVerificationStatus(id, status);
        return new ResponseUtil(200,"User : "+id+" verification status change to "+status,null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/changeDriver",params = {"requestCode","driver"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil changeDriverJob(@RequestParam String requestCode,@RequestParam String driver){
        rentRequestService.changeDriver(requestCode, driver);
        return  new ResponseUtil(200,"Rent Request : "+requestCode+" change to "+driver,null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/inspection",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil inspection(String registrationNumber,String status,double damageCost){
        return new ResponseUtil(200,"Done",paymentService.carInspection(registrationNumber, status, damageCost));
    }

}

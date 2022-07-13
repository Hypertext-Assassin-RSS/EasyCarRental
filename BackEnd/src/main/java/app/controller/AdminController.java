package app.controller;

import app.dto.AccountDTO;
import app.dto.AdminDTO;
import app.service.AccountService;
import app.service.AdminService;
import app.service.RentRequestService;
import app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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
    @GetMapping(params = {"date"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findTodayRentRequests(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return  new ResponseUtil(200,"Done",rentRequestService.getRentRequestToday(date));
    }
}

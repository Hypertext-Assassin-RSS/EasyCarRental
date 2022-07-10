package app.controller;

import app.dto.AccountDTO;
import app.dto.DriverDTO;
import app.dto.GustUserDTO;
import app.service.AccountService;
import app.service.DriverService;
import app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 10
 **/

@RestController
@CrossOrigin
@RequestMapping("api/v1/Driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @Autowired
    AccountService accountService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO driverDTO,@ModelAttribute AccountDTO accountDTO){
        driverService.saveDriver(driverDTO);
        accountService.saveAccount(accountDTO);
        return new ResponseUtil(200,"Diver From ID : "+driverDTO.getId()+" Saved!",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO driverDTO){
        driverService.updateDriver(driverDTO);
        return new ResponseUtil(200,"Driver ID : "+driverDTO.getId()+" is Updated!!",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers(GustUserDTO gustUserDTO){
        return new ResponseUtil(200,"Done!", driverService.getAllDrivers());
    }
}

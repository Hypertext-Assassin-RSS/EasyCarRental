package app.controller;

import app.dto.GustUserDTO;
import app.service.GustUserService;
import app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 05
 **/

@RestController
@RequestMapping("api/v1/GustUser")
@CrossOrigin
public class GustUserController {

    @Autowired
    GustUserService gustUserService;




    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil registerGustUser(@ModelAttribute GustUserDTO gustUserDTO){
        gustUserService.registerGustUser(gustUserDTO);
        return new ResponseUtil(200,"Customer : "+gustUserDTO.getId() +" saved successful!!",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllGustUsers(){
        return new ResponseUtil(200,"Get All Customers OK",gustUserService.getAllGustUsers());
    }
}

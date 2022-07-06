package app.controller;

import app.dto.GustUserDTO;
import app.service.GustUserService;
import org.springframework.beans.factory.annotation.Autowired;
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



    @PostMapping
    public void registerGustUser(@ModelAttribute GustUserDTO gustUserDTO){
        gustUserService.registerGustUser(gustUserDTO);
    }
}

package app.controller;

import app.dto.FileDTO;
import app.dto.GustUserDTO;
import app.service.DatabaseFileService;
import app.service.GustUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    DatabaseFileService databaseFileService;


    @PostMapping
    public void registerGustUser(@ModelAttribute GustUserDTO gustUserDTO,@ModelAttribute("file") MultipartFile file){
        gustUserService.registerGustUser(gustUserDTO);
        databaseFileService.storeFile(file);
    }
}

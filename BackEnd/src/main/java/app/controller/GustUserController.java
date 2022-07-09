package app.controller;

import app.dto.GustUserDTO;
import app.dto.RegisterUserDTO;
import app.entity.RegisterUser;
import app.service.GustUserService;
import app.service.RegisterUserService;
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

    @Autowired
    RegisterUserService registerUserService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil registerGustUser(@ModelAttribute GustUserDTO gustUserDTO, @ModelAttribute RegisterUserDTO registerUserDTO){
        gustUserService.registerGustUser(gustUserDTO);
        registerUserService.saveRegisterUser(registerUserDTO);
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

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchGustUser(@PathVariable  String id){
        return new ResponseUtil(200,"Done",gustUserService.searchGustUser(id));
    }
}

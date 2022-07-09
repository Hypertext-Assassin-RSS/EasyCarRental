package app.controller;

import app.dto.RegisterUserDTO;
import app.service.RegisterUserService;
import app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/

@RestController
@RequestMapping("api/v1/Register")
@CrossOrigin
public class RegisterUserController {

    @Autowired
    RegisterUserService registerUserService;

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateRegisterUser(@RequestBody RegisterUserDTO registerUserDTO){
        System.out.println(registerUserDTO.toString());
        registerUserService.updateRegisterUser(registerUserDTO);
        return new ResponseUtil(200,"User ID : "+registerUserDTO.getId()+"Email or Password  Updated!!!",null);
    }

}

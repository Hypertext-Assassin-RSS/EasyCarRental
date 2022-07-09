package app.controller;

import app.dto.RegisterUserDTO;
import app.service.RegisterUserService;
import app.service.RegisterUserServiceTest;
import app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/

@RestController
@RequestMapping("api/v1/RegisterTest")
@CrossOrigin
class RegisterUserControllerTest {

    @Autowired
    RegisterUserServiceTest registerUserService;

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateRegisterUser(@ModelAttribute RegisterUserDTO registerUserDTO){
        System.out.println(registerUserDTO.toString());
        registerUserService.updateRegisterUser(registerUserDTO);
        return new ResponseUtil(200,"Email : "+registerUserDTO.getEmail()+" Updated!!!",null);
    }

}
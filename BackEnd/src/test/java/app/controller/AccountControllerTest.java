package app.controller;

import app.dto.AccountDTO;
import app.service.AccountServiceTest;
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
@RequestMapping("api/v1/RegisterTest")
@CrossOrigin
class AccountControllerTest {

    @Autowired
    AccountServiceTest registerUserService;

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateRegisterUser(@ModelAttribute AccountDTO accountDTO){
        System.out.println(accountDTO.toString());
        registerUserService.updateRegisterUser(accountDTO);
        return new ResponseUtil(200,"Email : "+ accountDTO.getEmail()+" Updated!!!",null);
    }

}
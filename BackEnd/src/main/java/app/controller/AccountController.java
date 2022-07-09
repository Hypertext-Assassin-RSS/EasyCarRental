package app.controller;

import app.dto.AccountDTO;
import app.service.AccountService;
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
public class AccountController {

    @Autowired
    AccountService accountService;

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateAccount(@RequestBody AccountDTO accountDTO){
        System.out.println(accountDTO.toString());
        accountService.updateAccount(accountDTO);
        return new ResponseUtil(200,"User ID : "+ accountDTO.getId()+"Email or Password  Updated!!!",null);
    }

}

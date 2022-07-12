package app.controller;

import app.dto.RentRequestDTO;
import app.service.RentRequestService;
import app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/

@RestController
@RequestMapping("api/v1/Rent")
@CrossOrigin
public class RentRequestController {

    @Autowired
    RentRequestService rentRequestService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil makeRentRequest(@RequestBody RentRequestDTO rentRequestDTO){
       rentRequestService.makeRentRequest(rentRequestDTO);
       return new ResponseUtil(200,"RentRequest Code : "+rentRequestDTO.getRequestCode()+" is successful",null);
    }
}

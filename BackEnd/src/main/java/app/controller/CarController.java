package app.controller;

import app.dto.CardDTO;
import app.service.CarService;
import app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/

@RestController
@CrossOrigin
@RequestMapping("api/v1/Car")
public class CarController {

    @Autowired
    CarService carService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(CardDTO cardDTO){
        carService.saveCar(cardDTO);
        return new ResponseUtil(200,"Car : "+cardDTO.getRegistrationNumber()+" data Saved",null);
    }
}

package app.controller;

import app.dto.RentRequestDTO;
import app.service.PaymentService;
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

    @Autowired
    PaymentService paymentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil makeRentRequest(@RequestBody RentRequestDTO rentRequestDTO) {
        rentRequestService.makeRentRequest(rentRequestDTO);
        String waiverPayment = paymentService.calculateWaiverPayment(rentRequestDTO.getRequestCode());
        return new ResponseUtil(200, "RentRequest Code : " + rentRequestDTO.getRequestCode() + " is successful check Request Approval status after waiverPayment Done", waiverPayment);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRentRequests() {
        return new ResponseUtil(200, "Done", rentRequestService.getAllRentRequest());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRentRequest(@RequestBody RentRequestDTO rentRequestDTO) {
        rentRequestService.updateRentRequest(rentRequestDTO);
        return new ResponseUtil(200, "Rent Request : " + rentRequestDTO.getRequestCode() + " is Updated", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"requestCode"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRentRequest(@RequestParam String requestCode) {
        rentRequestService.deleteRentRequest(requestCode);
        return new ResponseUtil(200, "Rent Request : " + requestCode + " is deleted", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/{requestCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRentRequest(@PathVariable String requestCode) {
        return new ResponseUtil(200, "Done", rentRequestService.searchRentRequest(requestCode));
    }
}

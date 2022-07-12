package app.service;

import app.dto.RentRequestDTO;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/
public interface RentRequestService {

    public void makeRentRequest(RentRequestDTO rentRequestDTO);
}
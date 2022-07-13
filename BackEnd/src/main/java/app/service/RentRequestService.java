package app.service;

import app.dto.RentRequestDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/
public interface RentRequestService {

    public void makeRentRequest(RentRequestDTO rentRequestDTO);

    public List<RentRequestDTO> getAllRentRequest();

    public void updateRentRequest(RentRequestDTO rentRequestDTO);

    public void deleteRentRequest(String requestCode);

    public RentRequestDTO searchRentRequest(String requestCode);

    public List<RentRequestDTO> getRentRequestToday(LocalDate date);
}

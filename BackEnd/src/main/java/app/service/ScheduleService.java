package app.service;

import app.dto.RequestDetailsDTO;

import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 13
 **/
public interface ScheduleService {

    public List<RequestDetailsDTO> getAll(String driver);
}

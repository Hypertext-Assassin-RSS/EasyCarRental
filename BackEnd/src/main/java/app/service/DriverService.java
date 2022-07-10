package app.service;

import app.dto.DriverDTO;

import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 10
 **/
public interface DriverService {

    public void saveDriver(DriverDTO driverDTO);

    public void updateDriver(DriverDTO driverDTO);

    public List<DriverDTO> getAllDrivers();

    public void deleteDriver(String id);
}

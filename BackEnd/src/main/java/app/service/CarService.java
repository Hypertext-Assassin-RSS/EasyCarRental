package app.service;

import app.dto.CarDTO;

import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/
public interface CarService {

    public void saveCar(CarDTO carDTO);

    public List<CarDTO> getAllCars();
}

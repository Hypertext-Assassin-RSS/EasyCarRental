package app.service.impl;

import app.dto.CarDTO;
import app.entity.Car;
import app.repo.CarRepo;
import app.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/
@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo  carRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCar(CarDTO carDTO) {
        if (!carRepo.existsById(carDTO.getRegistrationNumber())){
            carRepo.save(modelMapper.map(carDTO, Car.class));
        }else {
            throw new RuntimeException("Car by RegistrationNumber : "+ carDTO.getRegistrationNumber()+" saved fail");
        }
    }

    @Override
    public List<CarDTO> getAllCars() {
        return modelMapper.map(carRepo.findAll(),new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public CarDTO searchCar(String RegistrationNumber) {
        if (carRepo.existsById(RegistrationNumber)){
            return modelMapper.map(carRepo.findById(RegistrationNumber),CarDTO.class);
        }else {
            throw new RuntimeException("No Car Found By RegistrationNumber : "+RegistrationNumber);
        }
    }
}

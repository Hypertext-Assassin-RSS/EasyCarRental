package app.service.impl;

import app.dto.CarDTO;
import app.entity.Car;
import app.repo.CarRepo;
import app.repo.RentRequestRepo;
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
    RentRequestRepo rentRequestRepo;

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

    @Override
    public void deleteCar(String RegistrationNumber) {
        Car car = carRepo.findById(RegistrationNumber).get();
        if (carRepo.existsById(RegistrationNumber)){
            if (car.getAvailability() > 0){
                carRepo.deleteById(RegistrationNumber);
            }else {
                throw new RuntimeException("This Car : "+RegistrationNumber+" is not returned by Customer yet");
            }
        }else {
            throw new RuntimeException("No Car Found by RegistrationNumber : "+RegistrationNumber);
        }
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        Car car = carRepo.findById(carDTO.getRegistrationNumber()).get();
        if (carRepo.existsById(carDTO.getRegistrationNumber())){
            if (car.getAvailability() > 0){
                carRepo.save(modelMapper.map(carDTO,Car.class));
            }else {
                throw new RuntimeException("This Car : "+carDTO.getRegistrationNumber()+" is not returned by Customer yet");
            }
        }else {
            throw new RuntimeException("No Car Found by RegistrationNumber : "+carDTO.getRegistrationNumber());
        }
    }
}

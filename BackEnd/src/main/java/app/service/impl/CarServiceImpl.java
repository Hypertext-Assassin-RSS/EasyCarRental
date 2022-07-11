package app.service.impl;

import app.dto.CardDTO;
import app.entity.Car;
import app.repo.CarRepo;
import app.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void saveCar(CardDTO cardDTO) {
        if (!carRepo.existsById(cardDTO.getRegistrationNumber())){
            carRepo.save(modelMapper.map(cardDTO, Car.class));
        }else {
            throw new RuntimeException("Car by RegistrationNumber : "+cardDTO.getRegistrationNumber()+" saved fail");
        }
    }
}

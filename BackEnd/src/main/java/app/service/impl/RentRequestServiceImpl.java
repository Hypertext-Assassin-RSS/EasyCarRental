package app.service.impl;

import app.dto.RentRequestDTO;
import app.entity.Car;
import app.entity.RentRequest;
import app.entity.RequestDetails;
import app.repo.CarRepo;
import app.repo.RentRequestRepo;
import app.service.RentRequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/

@Service
@Transactional
public class RentRequestServiceImpl implements RentRequestService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RentRequestRepo rentRequestRepo;

    @Autowired
    CarRepo carRepo;

    @Override
    public void makeRentRequest(RentRequestDTO rentRequestDTO) {
            RentRequest rentRequest = modelMapper.map(rentRequestDTO, RentRequest.class);
            if (!rentRequestRepo.existsById(rentRequestDTO.getRequestCode())){
                for (RequestDetails requestDetails:rentRequest.getRequestDetails()) {
                    Car car = carRepo.findById(requestDetails.getRegistrationNumber()).get();

                    if (car.getAvailability() > 0){
                        car.setAvailability(0);
                        rentRequestRepo.save(modelMapper.map(rentRequestDTO,RentRequest.class));
                    }else {
                        throw new RuntimeException("Car : "+car.getRegistrationNumber()+" is not available");
                    }
                }
            }else {
                throw new RuntimeException("Request : "+rentRequestDTO.getRequestCode()+" made failed!!!");
            }
        }

    @Override
    public List<RentRequestDTO> getAllRentRequest() {
        return modelMapper.map(rentRequestRepo.findAll(),new TypeToken<List<RentRequestDTO>>(){}.getType());

    }

    @Override
    public void updateRentRequest(RentRequestDTO rentRequestDTO) {
        if (rentRequestRepo.existsById(rentRequestDTO.getRequestCode())){
                rentRequestRepo.save(modelMapper.map(rentRequestDTO,RentRequest.class));
        }
    }
}



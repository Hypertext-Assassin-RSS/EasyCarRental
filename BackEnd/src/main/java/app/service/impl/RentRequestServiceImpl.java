package app.service.impl;

import app.dto.RentRequestDTO;
import app.entity.Car;
import app.entity.Driver;
import app.entity.RentRequest;
import app.entity.RequestDetails;
import app.repo.CarRepo;
import app.repo.DriverRepo;
import app.repo.RentRequestRepo;
import app.service.RentRequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    @Autowired
    DriverRepo driverRepo;

    @Override
    public void makeRentRequest(RentRequestDTO rentRequestDTO) {
            RentRequest rentRequest = modelMapper.map(rentRequestDTO, RentRequest.class);
            if (!rentRequestRepo.existsById(rentRequestDTO.getRequestCode())){
                for (RequestDetails requestDetails:rentRequest.getRequestDetails()) {
                    Car car = carRepo.findById(requestDetails.getRegistrationNumber()).get();
                    Boolean driverReq = requestDetails.getDriverRequest();
                    if (car.getAvailability() > 0){
                        car.setAvailability(0);
                        if (driverReq){
                            Driver driver = driverRepo.assignRandomDriver();
                            if (!(driver == null)){
                                driver.setAvailability(0);
                                rentRequestDTO.setDriver(driver.getName());
                                rentRequestRepo.save(modelMapper.map(rentRequestDTO,RentRequest.class));
                            }else {
                                throw new RuntimeException("Divers not available at this time");
                            }
                        }else {
                            rentRequestRepo.save(modelMapper.map(rentRequestDTO,RentRequest.class));
                        }
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

    @Override
    public void deleteRentRequest(String requestCode) {
        RentRequest  rentRequest = rentRequestRepo.findById(requestCode).get();
        if (rentRequestRepo.existsById(requestCode)){
            for (RequestDetails requestDetails:rentRequest.getRequestDetails()) {
                Car car = carRepo.findById(requestDetails.getRegistrationNumber()).get();
                if (car.getAvailability() > 0){
                    rentRequestRepo.deleteById(requestCode);
                }else {
                    throw new RuntimeException("Car : "+car.getRegistrationNumber()+" is not Returned yet!!");
                }
            }
        }else {
            throw new RuntimeException("Request : "+requestCode+" not found!!!");
        }
    }

    @Override
    public RentRequestDTO searchRentRequest(String requestCode) {
        if (rentRequestRepo.existsById(requestCode)){
            return  modelMapper.map(rentRequestRepo.findById(requestCode),RentRequestDTO.class);
        }else {
            throw new RuntimeException("No Rent Request Found By Code : "+requestCode);
        }
    }

    @Override
    public List<RentRequestDTO> getRentRequestToday(LocalDate date) {
        return modelMapper.map(rentRequestRepo.getRentRequestByDate(date),new TypeToken<List<RentRequestDTO>>(){}.getType());
    }
}



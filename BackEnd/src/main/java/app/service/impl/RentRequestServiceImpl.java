package app.service.impl;

import app.dto.RentRequestDTO;
import app.dto.ReturnCarDTO;
import app.entity.*;
import app.repo.CarRepo;
import app.repo.DriverRepo;
import app.repo.RentRequestRepo;
import app.repo.ReturnCarRepo;
import app.service.RentRequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    ReturnCarRepo returnCarRepo;

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
                                rentRequestDTO.setDriver(driver.getId());
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

    @Override
    public void changeRentRequestStatus(String requestCode,String status) {
        RentRequestDTO rentRequestDTO = modelMapper.map(rentRequestRepo.findById(requestCode), RentRequestDTO.class);
        if (rentRequestRepo.existsById(requestCode)){
            rentRequestDTO.setStatus(status);
            rentRequestRepo.save(modelMapper.map(rentRequestDTO,RentRequest.class));
        }else {
            throw new RuntimeException("RentRequest : "+requestCode+" is not found");
        }
    }

    @Override
    public void changeDriver(String requestCode, String driver) {
        if (rentRequestRepo.existsById(requestCode)){
            RentRequestDTO rentRequestDTO = modelMapper.map(rentRequestRepo.findById(requestCode), RentRequestDTO.class);
            rentRequestDTO.setDriver(driver);
            rentRequestRepo.save(modelMapper.map(rentRequestDTO,RentRequest.class));
        }else {
            throw new RuntimeException("RentRequest : "+requestCode+" is not found");
        }
    }

    @Override
    public void carReturn(String id) {
        List<RentRequest> rentRequests = rentRequestRepo.getAllByGustUser_Id(id);
        for (RentRequest rentRequest:rentRequests) {
            for (RequestDetails requestDetail : rentRequest.getRequestDetails()) {
                String registrationNumber = requestDetail.getRegistrationNumber();
                if (!returnCarRepo.existsById(registrationNumber)){
                    String gustUser = rentRequest.getGustUser().getId();
                    ReturnCarDTO returnCarDTO = new ReturnCarDTO();

                    returnCarDTO.setRegistrationNumber(registrationNumber);
                    returnCarDTO.setUserId(gustUser);
                    returnCarDTO.setStatus("inspection pending");

                    returnCarRepo.save(modelMapper.map(returnCarDTO,ReturnCar.class));
                }else {
                    throw new RuntimeException("Already return car request available for car : "+registrationNumber);
                }

            }

        }
    }
}



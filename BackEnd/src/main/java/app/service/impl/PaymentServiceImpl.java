package app.service.impl;

import app.dto.CarDTO;
import app.dto.RentRequestDTO;
import app.dto.RequestDetailsDTO;
import app.repo.CarRepo;
import app.repo.RentRequestRepo;
import app.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 14
 **/

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    double General = 10000.0;
    double Premium = 15000.0;
    double Luxury = 20000.0;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RentRequestRepo rentRequestRepo;

    @Autowired
    CarRepo carRepo;


    @Override
    public String calculateWaiverPayment(String requestCode) {
        if (rentRequestRepo.existsById(requestCode)){
            RentRequestDTO requestDTO = modelMapper.map(rentRequestRepo.findById(requestCode), RentRequestDTO.class);
            for (RequestDetailsDTO requestDetail : requestDTO.getRequestDetails()) {
                String registrationNumber = requestDetail.getRegistrationNumber();
                CarDTO carDTO = modelMapper.map(carRepo.findById(registrationNumber), CarDTO.class);
                String type = carDTO.getType();
                System.out.println(type);
                if (type.equals("General")){
                    System.out.println(General);
                    return "You have to pay Loss Damage Waiver payment : "+General +" if making payment remotely you can upload payment proof from payment section";
                } else if (type.equals("Premium")) {
                    System.out.println(Premium);
                    return "You have to pay Loss Damage Waiver payment : "+Premium+" if making payment remotely you can upload payment proof from payment section";
                } else if (type.equals("Luxury")) {
                    System.out.println(Luxury);
                    return "You have to pay Loss Damage Waiver payment : "+Luxury+" if making payment remotely you can upload payment proof from payment section";
                }else {
                    throw new RuntimeException("Can't Find Car Type");
                }
            }

        }else {
            throw new RuntimeException("No Rent Request Found In Given Code");
        }
        throw  new RuntimeException("Calculate Loss Damage Waiver payment Error Contact Rental Service");
    }
}

package app.service.impl;

import app.dto.CarDTO;
import app.dto.RentRequestDTO;
import app.dto.RequestDetailsDTO;
import app.entity.Car;
import app.entity.RentRequest;
import app.repo.CarRepo;
import app.repo.RentRequestRepo;
import app.service.PaymentService;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
        if (rentRequestRepo.existsById(requestCode)) {
            RentRequestDTO requestDTO = modelMapper.map(rentRequestRepo.findById(requestCode), RentRequestDTO.class);
            for (RequestDetailsDTO requestDetail : requestDTO.getRequestDetails()) {
                String registrationNumber = requestDetail.getRegistrationNumber();
                CarDTO carDTO = modelMapper.map(carRepo.findById(registrationNumber), CarDTO.class);
                String type = carDTO.getType();
                System.out.println(type);
                if (type.equals("General")) {
                    System.out.println(General);
                    return "You have to pay Loss Damage Waiver payment : " + General + " if making payment remotely you can upload payment proof from payment section";
                } else if (type.equals("Premium")) {
                    System.out.println(Premium);
                    return "You have to pay Loss Damage Waiver payment : " + Premium + " if making payment remotely you can upload payment proof from payment section";
                } else if (type.equals("Luxury")) {
                    System.out.println(Luxury);
                    return "You have to pay Loss Damage Waiver payment : " + Luxury + " if making payment remotely you can upload payment proof from payment section";
                } else {
                    throw new RuntimeException("Can't Find Car Type");
                }
            }

        } else {
            throw new RuntimeException("No Rent Request Found In Given Code");
        }
        throw new RuntimeException("Calculate Loss Damage Waiver payment Error Contact Rental Service");
    }


    @SneakyThrows
    @Override
    public String calculateRentalPayment(String id) {
        RentRequest rentRequest = rentRequestRepo.getRentRequestByGustUser_Id(id);
        System.out.println(rentRequest.getRequestCode());
        System.out.println("----------------------------------------------------");
        if (rentRequestRepo.existsById(rentRequest.getRequestCode())) {
            RentRequestDTO rentRequestDTO = modelMapper.map(rentRequestRepo.findById(rentRequest.getRequestCode()), RentRequestDTO.class);
            for (RequestDetailsDTO requestDetail : rentRequestDTO.getRequestDetails()) {

                System.out.println(requestDetail.toString());

                System.out.println("----------------------------------------------------");
                System.out.println(requestDetail.getPickupDate());
                System.out.println(requestDetail.getReturnDate());
                System.out.println("----------------------------------------------------");

                LocalDate pickupDate = requestDetail.getPickupDate();
                LocalDate returnDate = requestDetail.getReturnDate();

                long calculatePeriod = calculatePeriod(pickupDate, returnDate);


                CarDTO carDTO = modelMapper.map(carRepo.findById(requestDetail.getRegistrationNumber()), CarDTO.class);
                if (calculatePeriod >= 30) {

                    Double monthlyRate = carDTO.getMonthlyRate();
                    double period = (int) (calculatePeriod / 30);

                    System.out.println("----------------------------------------------------");
                    System.out.println("Period :"+calculatePeriod);
                    System.out.println("----------------------------------------------------");

                    double totalRent = monthlyRate * period;
                    System.out.println(totalRent);
                    System.out.println("----------------------------------------------------");

                    carDTO.setAvailability(1);
                    carRepo.save(modelMapper.map(carDTO, Car.class));

                    return "Yor Total Rent For : "+rentRequest.getRequestCode()+" is Rs :"+totalRent;
                } else {
                    double dailyRate = carDTO.getDailyRate();

                    System.out.println("----------------------------------------------------");
                    System.out.println("Period :"+calculatePeriod);
                    System.out.println("----------------------------------------------------");

                    double totalRent = calculatePeriod * dailyRate;
                    System.out.println(totalRent);
                    System.out.println("----------------------------------------------------");

                    carDTO.setAvailability(1);
                    carRepo.save(modelMapper.map(carDTO, Car.class));

                    return "Yor Total Rent For : "+rentRequest.getRequestCode()+" is Rs :"+totalRent;
                }
            }
        }
        throw new RuntimeException("Rent Calculate Error Please Contact Rental Service");
    }



    public long calculatePeriod(LocalDate pickupDate,LocalDate returnDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date firstDate = null;
        try {
            firstDate = sdf.parse(pickupDate.toString());
        } catch (ParseException e) {
            System.out.println(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
        Date secondDate = null;
        try {
            secondDate = sdf.parse(returnDate.toString());
        } catch (ParseException e) {
            System.out.println(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }

        System.out.println("----------------------------------------------------");
        System.out.println(firstDate);
        System.out.println(secondDate);
        System.out.println("----------------------------------------------------");

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        System.out.println(diff);

        return diff;
    }
}

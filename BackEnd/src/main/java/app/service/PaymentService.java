package app.service;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 14
 **/

public interface PaymentService {

    public String calculateWaiverPayment(String requestCode);

    public String calculateRentalPayment(String id);

    public String carInspection(String registrationNumber,String status,double damageCost);
}

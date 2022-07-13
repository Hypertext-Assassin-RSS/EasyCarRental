package app.entity;

import app.dto.CarDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/

@Entity(name = "Request_Details")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@IdClass(RentCar_PK.class)
public class RequestDetails {
    @Id
    private String requestCode;
    @Id
    private String registrationNumber;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private String pickupAddress="Company";
    private Boolean driverRequest;

    @ManyToOne
    @JoinColumn(name = "requestCode",referencedColumnName = "requestCode",insertable = false,updatable = false)
    private RentRequest rentRequests;

    @ManyToOne
    @JoinColumn(name = "RegistrationNumber",referencedColumnName = "registrationNumber",insertable = false,updatable = false)
    private Car cars;
}

package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/

@Entity(name = "Car_Details")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {
    @Id
    private String RegistrationNumber;
    private String Brand;
    private String Type;
    private String Color;
    private Integer PassengersCount;
    private String TransmissionType;
    private String FuelType;
    private Double DailyRate;
    private Double MonthlyRate;
    private Double FreeMileage;
    private Double ExtraMileagePrice;
    private int availability;
}

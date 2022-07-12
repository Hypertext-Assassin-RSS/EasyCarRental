package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarDTO {
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

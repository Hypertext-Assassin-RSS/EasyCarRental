package app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RequestDetailsDTO {
    private String requestCode;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private String pickupAddress;
    private String driverRequest;
    private String registrationNumber;
}

package app.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickupDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
    private String pickupAddress;
    private Boolean driverRequest;
    private String registrationNumber;
}

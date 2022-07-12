package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentCar_PK implements Serializable {
    private String requestCode;
    private String registrationNumber;
}

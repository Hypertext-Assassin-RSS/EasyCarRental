package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 14
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReturnCarDTO {
    String registrationNumber;
    String userId;
    String status = "inspection pending";
}

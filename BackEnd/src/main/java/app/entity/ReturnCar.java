package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 14
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity(name = "return_car")
public class ReturnCar {
    @Id
    String registrationNumber;
    String userId;
    String status = "inspection pending";
}

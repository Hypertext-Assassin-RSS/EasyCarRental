package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/

@Entity(name = "Rent_Request")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentRequest {
    @Id
    private String requestCode;
    private LocalDate date;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "userNicNo",referencedColumnName = "id",nullable = false)
    private GustUser gustUser;
}

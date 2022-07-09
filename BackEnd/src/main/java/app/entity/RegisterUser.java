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
 * @Date 2022 Jul 09
 **/

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RegisterUser {
    @Id
    private String email;
    private String password;
}

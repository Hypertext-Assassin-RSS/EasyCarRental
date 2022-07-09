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

@Entity(name = "Email_Password")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Account {
    @Id
    private String id;
    private String email;
    private String password;
}

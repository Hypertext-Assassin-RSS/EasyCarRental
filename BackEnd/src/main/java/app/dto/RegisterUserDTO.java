package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RegisterUserDTO {
    private String id;
    private String email;
    private String password;
}

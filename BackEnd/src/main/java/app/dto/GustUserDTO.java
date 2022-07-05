package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 05
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class GustUserDTO {
    private String id;
    private String licenseNo;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String password;
}

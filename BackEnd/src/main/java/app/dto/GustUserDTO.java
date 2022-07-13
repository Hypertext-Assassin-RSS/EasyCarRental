package app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerDate;
    private String verification = "pending";
}

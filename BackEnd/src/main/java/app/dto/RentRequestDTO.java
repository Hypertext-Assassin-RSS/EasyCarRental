package app.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentRequestDTO {
     private String requestCode;
     @JsonFormat(pattern = "yyyy-MM-dd")
     private LocalDate date;
     private GustUserDTO gustUser;
}

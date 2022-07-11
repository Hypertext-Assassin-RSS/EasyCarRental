package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AdminDTO {
    private String id;
    private String name;
}

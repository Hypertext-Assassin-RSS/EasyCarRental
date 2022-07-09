package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 05
 **/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GustUser {
    @Id
    private String id;
    private String licenseNo;
    private String name;
    private String address;
    private String contact;
}

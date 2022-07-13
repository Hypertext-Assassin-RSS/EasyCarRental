package app.repo;

import app.dto.DriverDTO;
import app.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 10
 **/

@Repository
public interface DriverRepo extends JpaRepository<Driver,String> {

    @Query(value = "SELECT * FROM driver_details WHERE availability = 1 ORDER BY  RAND() LIMIT 1", nativeQuery = true)
    Driver assignRandomDriver();
}

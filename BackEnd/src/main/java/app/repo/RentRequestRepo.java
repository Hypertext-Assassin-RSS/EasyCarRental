package app.repo;

import app.entity.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/

@Repository
public interface RentRequestRepo extends JpaRepository<RentRequest,String> {

    List<RentRequest> getRentRequestByDate(LocalDate date);

    RentRequest getRentRequestByGustUser_Id(String userNicNo);

    Boolean existsRentRequestByGustUser_Id(String id);

    @Query(value = "select * from rent_request where driver=?1", nativeQuery = true)
    public List<RentRequest> getAllByDriver(String driver);

    public List<RentRequest> getAllByGustUser_Id(String id);
}

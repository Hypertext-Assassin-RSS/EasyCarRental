package app.repo;

import app.entity.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
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
}

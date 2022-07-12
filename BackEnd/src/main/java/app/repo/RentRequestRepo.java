package app.repo;

import app.entity.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/

@Repository
public interface RentRequestRepo extends JpaRepository<RentRequest,String> {
}

package app.repo;

import app.entity.ReturnCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 14
 **/

@Repository
public interface ReturnCarRepo extends JpaRepository<ReturnCar,String> {

}

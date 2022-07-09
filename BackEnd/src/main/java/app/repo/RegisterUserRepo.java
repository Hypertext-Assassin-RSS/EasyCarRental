package app.repo;

import app.entity.GustUser;
import app.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/

@Repository
public interface RegisterUserRepo extends JpaRepository<RegisterUser,String> {
}

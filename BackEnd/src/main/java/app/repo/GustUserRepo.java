package app.repo;

import app.entity.GustUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 05
 **/

@Repository
public interface GustUserRepo extends JpaRepository<GustUser,String> {

}

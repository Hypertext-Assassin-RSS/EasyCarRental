package app.repo;

import app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/

@Repository
public interface AccountRepo extends JpaRepository<Account,String> {
    Boolean existsRegisterUserByEmail(String email);
}

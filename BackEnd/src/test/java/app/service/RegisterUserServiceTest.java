package app.service;

import app.dto.RegisterUserDTO;
import app.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/
public interface RegisterUserServiceTest {

    public void updateRegisterUser(RegisterUserDTO registerUserDTO);
}
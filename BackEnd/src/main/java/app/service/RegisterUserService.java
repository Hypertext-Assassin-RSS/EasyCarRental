package app.service;

import app.dto.RegisterUserDTO;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/
public interface RegisterUserService {
    public void saveRegisterUser(RegisterUserDTO registerUserDTO);
}

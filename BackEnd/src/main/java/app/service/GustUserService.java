package app.service;

import app.dto.GustUserDTO;

import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 05
 **/


public interface GustUserService {
    public void registerGustUser(GustUserDTO gustUserDTO);

    public List<GustUserDTO> getAllGustUsers();

    public void updateGustUser(GustUserDTO gustUserDTO);
}

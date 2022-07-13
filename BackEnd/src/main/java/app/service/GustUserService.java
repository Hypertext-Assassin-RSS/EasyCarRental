package app.service;

import app.dto.GustUserDTO;

import java.time.LocalDate;
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

    public void deleteGustUser(String id);

    GustUserDTO searchGustUser(String id);

    public List<GustUserDTO> getAllUsersRegisterToday(LocalDate date);

    public String checkRequestStatus(String id);

    public void changeVerificationStatus(String id,String status);

    public String checkVerificationStatus(String id);
}

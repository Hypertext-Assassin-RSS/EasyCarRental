package app.service;

import app.dto.AdminDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/


public interface AdminService {
    public void saveAdmin(AdminDTO adminDTO);

    public void deleteAdmin(String id);
}

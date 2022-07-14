package app.service.impl;

import app.dto.AdminDTO;
import app.entity.Admin;
import app.repo.AdminRepo;
import app.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/

@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void saveAdmin(AdminDTO adminDTO) {
        if (!adminRepo.existsById(adminDTO.getId())) {
            adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        } else {
            throw new RuntimeException("Admin " + adminDTO.getName() + " data save failed!!!");
        }
    }

    @Override
    public void deleteAdmin(String id) {
        if (adminRepo.existsById(id)) {
            adminRepo.deleteById(id);
        } else {
            throw new RuntimeException("No Admin found by ID : " + id);
        }
    }
}

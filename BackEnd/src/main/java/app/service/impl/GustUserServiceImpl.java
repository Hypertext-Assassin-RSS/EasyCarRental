package app.service.impl;

import app.dto.GustUserDTO;
import app.entity.GustUser;
import app.repo.DatabaseFileRepo;
import app.repo.GustUserRepo;
import app.service.GustUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 05
 **/

@Service
@Transactional
public class GustUserServiceImpl implements GustUserService {

    @Autowired
    GustUserRepo gustUserRepo;

    @Autowired
    DatabaseFileRepo databaseFileRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void registerGustUser(GustUserDTO gustUserDTO) {
        gustUserRepo.save(modelMapper.map(gustUserDTO, GustUser.class));
    }
}

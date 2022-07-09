package app.service.impl;

import app.config.WebAppConfig;
import app.dto.RegisterUserDTO;
import app.entity.RegisterUser;
import app.repo.RegisterUserRepo;
import app.service.RegisterUserServiceTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Service
class RegisterUserServiceImplTest implements RegisterUserServiceTest {

    @Autowired
    RegisterUserRepo registerUserRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void updateRegisterUser(RegisterUserDTO registerUserDTO) {
        if (registerUserRepo.existsById(registerUserDTO.getId())){
            registerUserRepo.save(modelMapper.map(registerUserDTO, RegisterUser.class));
        } else {
            throw  new RuntimeException("Update Fail");
        }
    }
}
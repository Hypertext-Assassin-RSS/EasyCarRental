package app.service.impl;

import app.dto.RegisterUserDTO;
import app.entity.RegisterUser;
import app.repo.RegisterUserRepo;
import app.service.RegisterUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/

@Service
@Transactional
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    RegisterUserRepo registerUserRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveRegisterUser(RegisterUserDTO registerUserDTO) {
        if (!registerUserRepo.existsById(registerUserDTO.getEmail())){
            registerUserRepo.save(modelMapper.map(registerUserDTO, RegisterUser.class));
        }else {
            throw new RuntimeException("Email : "+registerUserDTO.getEmail()+" is Registered With Another User");
        }

    }
}

package app.service.impl;

import app.dto.GustUserDTO;
import app.entity.GustUser;
import app.repo.NicRepo;
import app.repo.GustUserRepo;
import app.service.GustUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    ModelMapper modelMapper;

    @Override
    public void registerGustUser(GustUserDTO gustUserDTO) {
        if (!gustUserRepo.existsById(gustUserDTO.getId())){
            gustUserRepo.save(modelMapper.map(gustUserDTO, GustUser.class));
        }else {
            throw new RuntimeException("Customer from ID : "+gustUserDTO.getId()+" is Already Available!!!");
        }
    }

    @Override
    public List<GustUserDTO> getAllGustUsers() {
        return modelMapper.map(gustUserRepo.findAll(),new TypeToken<List<GustUserDTO>>(){}.getType());

    }
}

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
            throw new RuntimeException("User from ID : "+gustUserDTO.getId()+" is Already Available!!!");
        }
    }

    @Override
    public List<GustUserDTO> getAllGustUsers() {
        return modelMapper.map(gustUserRepo.findAll(),new TypeToken<List<GustUserDTO>>(){}.getType());

    }

    @Override
    public void updateGustUser(GustUserDTO gustUserDTO) {
        if (gustUserRepo.existsById(gustUserDTO.getId())){
            gustUserRepo.save(modelMapper.map(gustUserDTO,GustUser.class));
        }else {
            throw new RuntimeException("User : "+gustUserDTO.getId()+" is not Exists on Database!!!");
        }
    }

    @Override
    public void deleteGustUser(String id) {
        if(gustUserRepo.existsById(id)){
            gustUserRepo.deleteById(id);
        }else {
            throw new RuntimeException("User : "+id+" not Exists to Delete!!!");
        }
    }

    @Override
    public GustUserDTO searchGustUser(String id) {
        if (gustUserRepo.existsById(id)){
            return modelMapper.map(gustUserRepo.findById(id).get(),GustUserDTO.class);
        }else {
            throw new RuntimeException("User from ID : "+id+" not Exists to Find!!!");
        }
    }
}

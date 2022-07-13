package app.service.impl;

import app.dto.GustUserDTO;
import app.dto.RentRequestDTO;
import app.entity.GustUser;
import app.entity.RentRequest;
import app.repo.NicRepo;
import app.repo.GustUserRepo;
import app.repo.RentRequestRepo;
import app.service.GustUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    RentRequestRepo rentRequestRepo;

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
            return modelMapper.map(gustUserRepo.findById(id),GustUserDTO.class);
        }else {
            throw new RuntimeException("User from ID : "+id+" not Exists to Find!!!");
        }
    }

    @Override
    public List<GustUserDTO> getAllUsersRegisterToday(LocalDate date) {
        return modelMapper.map(gustUserRepo.getAllByRegisterDate(date),new TypeToken<List<GustUserDTO>>(){}.getType());
    }

    @Override
    public String checkRequestStatus(String id) {
        RentRequest rentRequest = rentRequestRepo.getRentRequestByGustUser_Id(id);
        if (rentRequestRepo.existsRentRequestByGustUser_Id(id)){
            return rentRequest.getStatus();
        }else {
            throw new RuntimeException("No Rent Request Found By User ID : "+id);
        }
    }

    @Override
    public void changeVerificationStatus(String id,String status) {
        GustUser gustUser = gustUserRepo.findById(id).get();
        if (gustUserRepo.existsById(id)){
            gustUser.setVerification(status);
            gustUserRepo.save(gustUser);
        } else {
            throw  new RuntimeException("No user found to change verification");
        }
    }

    @Override
    public String checkVerificationStatus(String id) {
        if (gustUserRepo.existsById(id)){
            GustUser gustUser = gustUserRepo.findById(id).get();
            return gustUser.getVerification();
        }else {
            throw new RuntimeException("User Not Found By ID : "+id);
        }

    }
}

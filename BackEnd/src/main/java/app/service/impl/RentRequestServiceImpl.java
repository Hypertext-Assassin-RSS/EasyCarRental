package app.service.impl;

import app.dto.RentRequestDTO;
import app.entity.RentRequest;
import app.repo.RentRequestRepo;
import app.service.RentRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 12
 **/

@Service
@Transactional
public class RentRequestServiceImpl implements RentRequestService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RentRequestRepo rentRequestRepo;

    @Override
    public void makeRentRequest(RentRequestDTO rentRequestDTO) {
       if (!rentRequestRepo.existsById(rentRequestDTO.getRequestCode())){
           rentRequestRepo.save(modelMapper.map(rentRequestDTO, RentRequest.class));
       }else {
           throw new RuntimeException("Request : "+rentRequestDTO.getRequestCode()+" made failed!!!");
       }
    }
}

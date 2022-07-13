package app.service.impl;

import app.dto.RequestDetailsDTO;
import app.entity.RentRequest;
import app.entity.RequestDetails;
import app.repo.RentRequestRepo;
import app.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 13
 **/

@Transactional
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    RentRequestRepo rentRequestRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<RequestDetailsDTO> getAll(String driver) {
        List<RequestDetailsDTO> dtoList = new ArrayList<>();
        for (RentRequest rentRequest : rentRequestRepo.getAllByDriver(driver)) {
            for (RequestDetails requestDetail : rentRequest.getRequestDetails()) {
                dtoList.add(modelMapper.map(requestDetail,RequestDetailsDTO.class));
            }
        }
        return dtoList;
    }
}

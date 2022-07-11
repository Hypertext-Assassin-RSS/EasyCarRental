package app.service.impl;

import app.dto.DriverDTO;
import app.entity.Driver;
import app.repo.DriverRepo;
import app.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 10
 **/

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if (!driverRepo.existsById(driverDTO.getId())){
            driverRepo.save(modelMapper.map(driverDTO, Driver.class));
        }else {
            throw new RuntimeException("Driver Save Failed!!!");
        }
    }

    @Override
    public void updateDriver( DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getId())){
            driverRepo.save(modelMapper.map(driverDTO,Driver.class));
        }else {
            throw new RuntimeException("Driver : "+driverDTO.getId()+" update Failed!!");
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return modelMapper.map(driverRepo.findAll(),new TypeToken<List<DriverDTO>>(){}.getType());

    }

    @Override
    public void deleteDriver(String id) {
        if (driverRepo.existsById(id)){
            driverRepo.deleteById(id);
        }else {
            throw new RuntimeException("Driver From ID : "+id+" is Not Found!!!");
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        if (driverRepo.existsById(id)){
             return modelMapper.map(driverRepo.findById(id),DriverDTO.class);
        }else {
            throw new RuntimeException("No Driver Found by ID : "+id);
        }
    }
}

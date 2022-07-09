package app.service.impl;

import app.dto.AccountDTO;
import app.entity.Account;
import app.repo.AccountRepo;
import app.service.AccountService;
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
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveAccount(AccountDTO accountDTO) {
        if (!accountRepo.existsById(accountDTO.getEmail())){
            accountRepo.save(modelMapper.map(accountDTO, Account.class));
        }else {
            throw new RuntimeException("Email : "+ accountDTO.getEmail()+" is Registered With Another User");
        }

    }

    @Override
    public void updateAccount(AccountDTO accountDTO) {
        if (accountRepo.existsById(accountDTO.getId())){
            accountRepo.save(modelMapper.map(accountDTO, Account.class));
        } else {
            throw  new RuntimeException("Update Fail");
        }
    }
}

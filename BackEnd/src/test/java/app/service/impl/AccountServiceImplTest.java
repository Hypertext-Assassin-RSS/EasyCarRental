package app.service.impl;

import app.config.WebAppConfig;
import app.dto.AccountDTO;
import app.entity.Account;
import app.repo.AccountRepo;
import app.service.AccountServiceTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Service
class AccountServiceImplTest implements AccountServiceTest {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void updateRegisterUser(AccountDTO accountDTO) {
        if (accountRepo.existsById(accountDTO.getId())){
            accountRepo.save(modelMapper.map(accountDTO, Account.class));
        } else {
            throw  new RuntimeException("Update Fail");
        }
    }
}
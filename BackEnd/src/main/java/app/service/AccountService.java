package app.service;

import app.dto.AccountDTO;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 09
 **/
public interface AccountService {
    public void saveAccount(AccountDTO accountDTO);

    public void updateAccount(AccountDTO accountDTO);

    public Boolean login(String email,String password);
}

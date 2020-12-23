package com.divary.service;

import com.divary.entity.Account;

import java.util.List;

public interface AccountService {

    Account createAccount (Account account);

    Account getAccountById (Integer id);

    List<Account> getAllAccount (String sort, String orderBy);

}

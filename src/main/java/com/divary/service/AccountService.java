package com.divary.service;

import com.divary.entity.Account;

import java.util.List;

public interface AccountService {

    public Account createAccount (Account account);

    public Account getAccountById (Integer id);

    public List<Account> getAllAccount ();

}

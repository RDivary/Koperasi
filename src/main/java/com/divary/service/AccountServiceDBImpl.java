package com.divary.service;

import com.divary.entity.Account;
import com.divary.exceptions.IdNotFound;
import com.divary.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceDBImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        account.setPoint(0);
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Integer id) {
        if (accountRepository.findById(id).isPresent()) {
            return accountRepository.findById(id).get();
        }
        throw new IdNotFound("user", id.toString());
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

}

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

        return accountRepository.findById(id).orElseThrow(() -> new IdNotFound("user", id.toString()));

    }

    @Override
    public List<Account> getAllAccount(String sort, String orderBy) {

        switch (sort.toLowerCase()){

            case "point":
                if (orderBy.equalsIgnoreCase("asc")) return accountRepository.findByOrderByPointAsc();
                return accountRepository.findByOrderByPointDesc();
            case "balance":
                if (orderBy.equalsIgnoreCase("asc")) return accountRepository.findByOrderByBalanceAsc();
                return accountRepository.findByOrderByBalanceDesc();
            default:
                return accountRepository.findAll();
        }

    }

}

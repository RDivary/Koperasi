package com.divary.controller;

import com.divary.entity.Account;
import com.divary.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Integer id){
        return accountService.getAccountById(id);
    }

    @GetMapping()
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }

}

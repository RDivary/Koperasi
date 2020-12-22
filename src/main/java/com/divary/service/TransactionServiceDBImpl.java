package com.divary.service;

import com.divary.entity.Account;
import com.divary.entity.Transaction;
import com.divary.exceptions.BalanceNotEnough;
import com.divary.exceptions.ErrorDebitCreditStatus;
import com.divary.exceptions.ErrorDescription;
import com.divary.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Service
public class TransactionServiceDBImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountService accountService;

    @Override
    public Transaction createTransaction(Transaction transaction) {

        int balance;
        Account account = accountService.getAccountById(transaction.getAccount().getAccountId());
        transaction.setAccount(account);

        if (transaction.getDebitCreditStatus() == 'D') {

            if (account.getBalance() < transaction.getAmount()) throw new BalanceNotEnough();

            String[] description = {"Beli pulsa", "Bayar Listrik", "Tarik Tunai"};

            if (!Arrays.asList(description).contains(transaction.getDescription())) throw new ErrorDescription(transaction.getDescription(), "Debit");

            balance = account.getBalance() - transaction.getAmount();

        } else if (transaction.getDebitCreditStatus() == 'C'){
            balance = account.getBalance() + transaction.getAmount();

        } else {
            throw new ErrorDebitCreditStatus(transaction.getDebitCreditStatus().toString());
        }
        account.setBalance(balance);
        transaction.setBalance(balance);
        transaction.setTransactionDate(new Date());

        return transactionRepository.save(transaction);
    }
}
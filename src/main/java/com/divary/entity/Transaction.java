package com.divary.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_transaction")
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String transactionsId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date transactionDate;
    private String description;
    private Character debitCreditStatus;
    private Integer amount;
    private Integer balance;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties(value = {"transactions"})
    private Account account;

    public Transaction() {
    }

    public String getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(String transactionsId) {
        this.transactionsId = transactionsId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getDebitCreditStatus() {
        return debitCreditStatus;
    }

    public void setDebitCreditStatus(Character debitCreditStatus) {
        this.debitCreditStatus = debitCreditStatus;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

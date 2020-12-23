package com.divary.repository;

import com.divary.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findByOrderByPointDesc();
    List<Account> findByOrderByPointAsc();

    List<Account> findByOrderByBalanceDesc();
    List<Account> findByOrderByBalanceAsc();

}

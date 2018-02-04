package com.recommend_system.account.service.impl;

import com.recommend_system.account.dao.AccountDao;
import com.recommend_system.account.entity.Account;
import com.recommend_system.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountDao accountDao;

    @Override
    public void register(Account account){ accountDao.register(account); }

    @Override
    public Account logIn(Account account){ return accountDao.logIn(account); }
}
package com.recommend_system.account.service;

import com.recommend_system.account.entity.Account;

public interface AccountService {//service接口
    public void register(Account account);
    public Account logIn(Account account);
}


package com.recommend_system.user.service;

import com.recommend_system.user.entity.User;

public interface UserService {
    void register(User user);//注册方法，空返回值，插入新的User到表中
    User logIn(User user);//登录方法，根据用户名密码查表，正确则返回User类，否则返回空
}

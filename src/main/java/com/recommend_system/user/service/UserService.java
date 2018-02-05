
package com.recommend_system.user.service;

import com.recommend_system.user.entity.User;

/*
此为User Service接口层
 */

public interface UserService {
    /*
     *注册方法，传入User对象，插入新的User到数据库表中，空返回值
     */
    void register(User user);
    /*
     *登录方法，传入User对象，根据用户名密码查表，正确则返回User类，否则返回空值
     */
    User logIn(User user);
}

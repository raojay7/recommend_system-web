
package com.recommend_system.user.service;

import com.recommend_system.user.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/*
此为User Service接口层
 */

public interface UserService {
    /*
     *注册方法
     * @param user:User对象，插入新的User到数据库表中，空返回值
     */
    void register(User user);

    /*
     *登录方法
     * @param user:User对象，根据用户名密码查表
     * @return User:信息核实正确则返回User类，否则返回空值
     */
    User logIn(User user);
    /*
     *修改个人信息方法
     * @param user:用户修改后的用户bean
     */
    public void setUser(User user);
}

package com.recommend_system.test.service;

import com.recommend_system.user.dao.UserMapper;
import com.recommend_system.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService
{

    @Autowired
    public UserMapper userMapper;

    public void show()
    {
        System.out.println("service的show方法");
    }

    public int insert(User user){
        return userMapper.insert(user);
    }
}

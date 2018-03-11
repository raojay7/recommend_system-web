package com.recommend_system.test.service;

import com.recommend_system.user.dao.UserMapper;
import com.recommend_system.user.entity.User;
import com.recommend_system.user.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceTest {
    @Autowired
    private UserMapper userMapper;

    public void registerTest(User user){
        userMapper.insert(user);
    }

    public User logInTest(User user){
        try {
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserIdEqualTo(user.getUserId());
            criteria.andPasswordEqualTo(user.getPassword());
            List<User> list = userMapper.selectByExample(userExample);
            return list.get(0);
        }catch (Exception e){
            throw e;
        }
    }
    public void setUserTest(User user){
        userMapper.updateByPrimaryKey(user);
    }
}

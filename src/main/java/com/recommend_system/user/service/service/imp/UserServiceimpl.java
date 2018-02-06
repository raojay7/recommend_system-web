package com.recommend_system.user.service.service.imp;

import com.recommend_system.user.dao.UserMapper;
import com.recommend_system.user.entity.User;
import com.recommend_system.user.entity.UserExample;
import com.recommend_system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insert(user);
        /*if(userMapper == null)System.out.println("UserMapper is null!");
        else System.out.println("not null~"); */
    }

    @Override
    public User logIn(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> list = userMapper.selectByExample(userExample);
        return list.get(0);
    }

    @Override
    public void setUser(User user){
        userMapper.updateByPrimaryKey(user);
    }

}

package com.recommend_system.test.service;

import com.recommend_system.user.dao.UserJobIntensionMapper;
import com.recommend_system.user.entity.UserJobIntension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJobIntensionServiceTest {
    @Autowired
    private UserJobIntensionMapper userJobIntensionMapper;

    public void addIntensionTest(UserJobIntension userJobIntension){
        userJobIntensionMapper.insert(userJobIntension);
    }

    public void setIntensionTest(UserJobIntension userJobIntension){
        userJobIntensionMapper.updateByPrimaryKey(userJobIntension);
    }
}

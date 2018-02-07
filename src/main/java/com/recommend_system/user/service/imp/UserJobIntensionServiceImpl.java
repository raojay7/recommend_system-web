package com.recommend_system.user.service.imp;

import com.recommend_system.user.dao.UserJobIntensionMapper;
import com.recommend_system.user.entity.UserJobIntension;
import com.recommend_system.user.service.UserJobIntensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJobIntensionServiceImpl implements UserJobIntensionService {
    @Autowired
    private UserJobIntensionMapper userJobIntensionMapper;

    @Override
    public void setIntension(UserJobIntension userJobIntension) {
        userJobIntensionMapper.updateByPrimaryKey(userJobIntension);
    }

    @Override
    public void addIntension(UserJobIntension userJobIntension) {
        userJobIntensionMapper.insert(userJobIntension);
    }
}

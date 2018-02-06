package com.recommend_system.user.service.service.imp;

import com.recommend_system.user.service.UserJobIntensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJobIntensionServiceImpl implements UserJobIntensionService {
    @Autowired
    UserJobIntensionMapper userJobIntensionMapper;

    @Override
    public void setIntension(UserJobIntension userJobIntension) {

    }

    @Override
    public void addIntension(UserJobIntension userJobIntension) {

    }
}

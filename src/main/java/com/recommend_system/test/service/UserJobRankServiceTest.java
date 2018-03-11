package com.recommend_system.test.service;

import com.recommend_system.userlike.dao.UserJobRankMapper;
import com.recommend_system.userlike.entity.UserJobRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJobRankServiceTest {
    @Autowired
    private UserJobRankMapper userJobRankMapper;

    public int presocre(UserJobRank userJobRank){
        return userJobRankMapper.insert(userJobRank);
    }
}

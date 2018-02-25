package com.recommend_system.userlike.service;

import com.recommend_system.user.entity.User;
import com.recommend_system.user.entity.UserJobIntension;

public interface UserJobRankService {

    public int prescore(User user, UserJobIntension userJobIntension);
}

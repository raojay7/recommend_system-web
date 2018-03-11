package com.recommend_system.test.controller;

import com.recommend_system.test.service.UserJobRankServiceTest;
import com.recommend_system.userlike.entity.UserJobRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class UserJobRankControllerTest {
    @Autowired
    private UserJobRankServiceTest userJobRankServiceTest;

    @RequestMapping("prescoreTest")
    public void prescoreTest(UserJobRank userJobRank){
        System.out.println("affected:"+userJobRankServiceTest.presocre(userJobRank));
    }
}

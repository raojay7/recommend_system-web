package com.recommend_system.userlike.service.imp;

import com.recommend_system.company.dao.CompanyMapper;
import com.recommend_system.company.entity.CompanyExample;
import com.recommend_system.job.dao.JobMapper;
import com.recommend_system.job.entity.Job;
import com.recommend_system.user.entity.User;
import com.recommend_system.userlike.dao.UserJobRankMapper;
import com.recommend_system.userlike.dao.UserLikeMapper;
import com.recommend_system.userlike.entity.UserJobRank;
import com.recommend_system.userlike.entity.UserJobRankExample;
import com.recommend_system.userlike.entity.UserLikeExample;
import com.recommend_system.userlike.entity.UserLikeKey;
import com.recommend_system.userlike.service.UserLikeService;
import com.taotao.common.pojo.SolrItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserLikeServiceImpl implements UserLikeService {
    @Autowired
    UserLikeMapper userLikeMapper;
    @Autowired
    UserJobRankMapper userJobRankMapper;
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public void delete(int uid, int jid) {
        UserLikeKey userLikeKey = new UserLikeKey();
        userLikeKey.setJobId(jid);
        userLikeKey.setUserId(uid);
        userLikeMapper.deleteByPrimaryKey(userLikeKey);
        UserJobRankExample userJobRankExample = new UserJobRankExample();
        UserJobRankExample.Criteria criteria = userJobRankExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        criteria.andJobIdEqualTo(jid);
        UserJobRank userJobRank = userJobRankMapper.selectByExample(userJobRankExample).get(0);
        userJobRank.setGrade(userJobRank.getGrade() - 0.5);
        userJobRankMapper.updateByPrimaryKeySelective(userJobRank);
    }

    @Override
    public List<UserLikeKey> getList(int uid) {
        UserLikeExample userLikeExample = new UserLikeExample();
        UserLikeExample.Criteria criteria = userLikeExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        return userLikeMapper.selectByExample(userLikeExample);
    }

    @Override
    public List<SolrItem> getLikeList(int uid) {
        List<SolrItem> slist = new LinkedList<>();
        SolrItem si;
        UserLikeExample userLikeExample = new UserLikeExample();
        UserLikeExample.Criteria criteria = userLikeExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        List<UserLikeKey> list = userLikeMapper.selectByExample(userLikeExample);
        if(list.size() == 0)return null;
        for(UserLikeKey userLikeKey : list){
            si = new SolrItem();
            Job njob = jobMapper.selectByPrimaryKey(userLikeKey.getJobId());
            si.setCompanyId(njob.getCompanyId());
            si.setCtime(njob.getCtime());
            si.setEducation(njob.getEducation());
            si.setJobName(njob.getJobName());
            si.setJobId(njob.getJobId());
            si.setJobNature(njob.getJobNature());
            si.setNeedNum(njob.getNeedNum());
            si.setSalaryMax(njob.getSalaryMax());
            si.setSalaryMin(njob.getSalaryMin());
            si.setSpecification(njob.getSpecification());
            si.setWelfare(njob.getWelfare());
            si.setWorkcity(njob.getWorkcity());
            si.setWorkexperienceMax(njob.getWorkexperienceMax());
            si.setWorkexperienceMin(njob.getWorkexperienceMin());
            si.setWorkplace(njob.getWorkplace());
            CompanyExample companyExample = new CompanyExample();
            CompanyExample.Criteria criteria1 = companyExample.createCriteria();
            criteria1.andCompanyIdEqualTo(njob.getCompanyId());
            si.setCompanyName(companyMapper.selectByExample(companyExample).get(0).getCompanyName());
            slist.add(si);
        }
        return slist;
    }

    @Override
    public void collect(int uid, int jid) {
        UserLikeKey userLikeKey = new UserLikeKey();
        userLikeKey.setJobId(jid);
        userLikeKey.setUserId(uid);
        userLikeMapper.insert(userLikeKey);
        UserJobRankExample userJobRankExample = new UserJobRankExample();
        UserJobRankExample.Criteria criteria = userJobRankExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        criteria.andJobIdEqualTo(jid);
        List<UserJobRank> userJobRankList = userJobRankMapper.selectByExample(userJobRankExample);
        if(userJobRankList.size() != 0) {
            UserJobRank userJobRank = userJobRankList.get(0);
            userJobRank.setGrade(userJobRank.getGrade() + 0.5);
            userJobRankMapper.updateByPrimaryKeySelective(userJobRank);
        }else{
            UserJobRank record = new UserJobRank();
            record.setGrade(1.4933071490757153);
            record.setJobId(jid);
            record.setUserId(uid);
            userJobRankMapper.insert(record);
        }
    }
}

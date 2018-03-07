package com.recommend_system.uservisit.service.imp;

import com.recommend_system.uservisit.dao.VisitJobMapper;
import com.recommend_system.uservisit.entity.VisitJob;
import com.recommend_system.uservisit.entity.VisitJobExample;
import com.recommend_system.uservisit.service.UserVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserVisitServiceImpl implements UserVisitService {

    @Autowired
    private VisitJobMapper visitJobMapper;

    @Override
    public List<VisitJob> getRecentVisit(int uid) {
        VisitJobExample visitJobExample = new VisitJobExample();
        VisitJobExample.Criteria criteria = visitJobExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        visitJobExample.setOrderByClause("visisted_job_id desc");
        List<VisitJob> list = visitJobMapper.selectByExample(visitJobExample);
        List<VisitJob> finalList = new LinkedList<>();
        int count = 0, num = 6;
            Iterator<VisitJob> it = list.iterator();
            VisitJob vj;
            while (it.hasNext()) {
                vj = it.next();
                if(!finalList.contains(vj)) {
                    finalList.add(vj);
                    count++;
                }
                if (count == num) break;
            }
        return finalList;
    }

    @Override
    public boolean isEmpty(int uid) {
        VisitJobExample visitJobExample = new VisitJobExample();
        VisitJobExample.Criteria criteria = visitJobExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        List<VisitJob> list = visitJobMapper.selectByExample(visitJobExample);
        return list.size() == 0 ? true : false;
    }

    @Override
    public void visit(int uid, int jid) {
        VisitJob visitJob = new VisitJob();
        visitJob.setUserId(uid);
        visitJob.settJobId(jid);
        visitJob.setServerTime(new Date());
        visitJobMapper.insert(visitJob);
    }
}

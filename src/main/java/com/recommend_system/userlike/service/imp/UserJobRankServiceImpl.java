package com.recommend_system.userlike.service.imp;

import com.recommend_system.company.dao.CompanyMapper;
import com.recommend_system.company.entity.Company;
import com.recommend_system.company.entity.CompanyExample;
import com.recommend_system.job.dao.JobMapper;
import com.recommend_system.job.entity.Job;
import com.recommend_system.job.entity.JobExample;
import com.recommend_system.user.dao.UserJobIntensionMapper;
import com.recommend_system.user.entity.User;
import com.recommend_system.user.entity.UserJobIntension;
import com.recommend_system.user.entity.UserJobIntensionExample;
import com.recommend_system.userlike.dao.UserJobRankMapper;
import com.recommend_system.userlike.entity.UserJobRank;
import com.recommend_system.userlike.entity.UserJobRankExample;
import com.recommend_system.userlike.service.UserJobRankService;
import com.recommend_system.utils.RecommendFactory;
import com.taotao.common.pojo.SolrItem;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

import static java.lang.Math.E;

@Service
public class UserJobRankServiceImpl implements UserJobRankService {
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private UserJobRankMapper userJobRankMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private UserJobIntensionMapper userJobIntensionMapper;

    public static void randomSet(int min, int max, int n, HashSet<Integer> set) {
        if (n > (max - min + 1) || max < min) {
            n = max - min + 1;
        }
        for (int i = 0; i < n; i++) {
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);// 将不同的数存入HashSet中
        }
        int setSize = set.size();
        // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
        if (setSize < n) {
            randomSet(min, max, n - setSize, set);// 递归
        }
    }

    public boolean existLess(List<Job> clist, int value){
        Job cjob;
        for(int j = 0; j < clist.size(); j++){
            cjob = clist.get(j);
            if(cjob.getSalaryMin() < value)return true;
        }
        return false;
    }
    @Override
    public List<SolrItem> recommend(User user, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path))));
            UserJobRankExample example = new UserJobRankExample();
            UserJobRankExample.Criteria validataCriteria = example.createCriteria();
            validataCriteria.andGradeIsNotNull();
            List<UserJobRank> ujrList = userJobRankMapper.selectByExample(example);
            Iterator<UserJobRank> it = ujrList.iterator();
            UserJobRank userJobRank;
            String text;
            while(it.hasNext()){
                userJobRank = it.next();
                text = userJobRank.getUserId() + "," + userJobRank.getJobId() + "," + userJobRank.getGrade();
                bw.write(text);
                bw.newLine();
            }
            bw.close();

            //mahout推荐-------------------------------
            //基于项目的协同过滤
            DataModel dm = RecommendFactory.buildDataModel(path);
            ItemSimilarity is = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.CITYBLOCK, dm);
            RecommenderBuilder rb = RecommendFactory.itemRecommender(is, true);

            //-----结果评估---------
            //测试该方法平均绝对偏差
            //RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, rb, null, dm, 0.7);
            //测试该方法的Precision(相关的结果集/相关的+不相关的)和Recall(全部相关结果集中 检索到的/检索到的+未检索到的)
            //RecommendFactory.statsEvaluator(rb, null, dm, 2);

            List<RecommendedItem> list = rb.buildRecommender(dm).recommend(user.getUserId(), 10);
            //基于用户的协同过滤
            /*DataModel dm = RecommendFactory.buildDataModel(path);
            UserSimilarity us = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dm);
            UserNeighborhood un = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.THRESHOLD, us, dm, 0.2);
            RecommenderBuilder rb = RecommendFactory.userRecommender(us, un, true);
            List<RecommendedItem> list = rb.buildRecommender(dm).recommend(user.getUserId(),10);*/
            //-------------------------

                List<Job> jlist = new LinkedList<>();
                Iterator<RecommendedItem> rit = list.iterator();
                RecommendedItem ri;
                int jid;
                while(rit.hasNext()){
                    ri = rit.next();
                    jid = (int) ri.getItemID();
                    //System.out.println("jid:"+jid);
                    JobExample je = new JobExample();
                    JobExample.Criteria jec = je.createCriteria();
                    jec.andJobIdEqualTo(jid);
                    jlist.add(jobMapper.selectByExample(je).get(0));

                }

                //----ambiguousSearch to enhance jobList by mahout
            UserJobIntensionExample userJobIntensionExample = new UserJobIntensionExample();
                UserJobIntensionExample.Criteria ujiCriteria = userJobIntensionExample.createCriteria();
                ujiCriteria.andUserIdEqualTo(user.getUserId());
                List<UserJobIntension> ujiList = userJobIntensionMapper.selectByExample(userJobIntensionExample);
                UserJobIntension userJobIntension = ujiList.get(0);
                JobExample enhanceExample = new JobExample();
                JobExample.Criteria enhanceCriteria = enhanceExample.createCriteria();
                //System.out.println(userJobIntension.getWorkplace()+" "+userJobIntension.getJobName()+" "+user.getEducation()+" "+userJobIntension.getJobNature()+" "+userJobIntension.getSalaryMin());
                enhanceCriteria.andWorkcityEqualTo(userJobIntension.getWorkplace());
                enhanceCriteria.andJobNameLike("%" + userJobIntension.getJobName() + "%");
                enhanceCriteria.andEducationLessThanOrEqualTo(user.getEducation());
                enhanceCriteria.andJobNatureEqualTo(userJobIntension.getJobNature());
                enhanceCriteria.andSalaryMinGreaterThanOrEqualTo(userJobIntension.getSalaryMin());
                List<Job> enhanceJobList = jobMapper.selectByExample(enhanceExample);
                //jlist.addAll(enhanceJobList);

                /*Iterator<Job> filterIt = jlist.iterator();
                Job checkJob;
                while(filterIt.hasNext()){
                    checkJob = filterIt.next();
                    if(checkJob.getSalaryMin() < userJobIntension.getSalaryMin())jlist.remove(checkJob);
                }*/

                //System.out.println(enhanceJobList);
                jlist.addAll(enhanceJobList);
                for(int k=0;k<jlist.size();k++){
                    Job tjob = jlist.get(k);
                    System.out.println("jobid:"+tjob.getJobId()+"jobname:"+tjob.getJobName()+" workplace:"+tjob.getWorkcity());
                }
            //filter jobs whose sm < user.sm
            Job valijob;
            while(existLess(jlist, userJobIntension.getSalaryMin())){
                for (int i = 0; i < jlist.size(); i++) {
                    valijob = jlist.get(i);
                    if (valijob.getSalaryMin() < userJobIntension.getSalaryMin()) {
                        //System.out.println("不合格的薪水：" + valijob.getSalaryMin());
                        jlist.remove(valijob);
                    }
                }
            }
            /*for(int i = 0; i < jlist.size(); i++){
                    System.out.println("筛选后的薪水："+jlist.get(i).getSalaryMin());

            }*/
            //每次访问都随机取五个
            HashSet<Integer> set = new HashSet<>();
            randomSet(0, jlist.size() - 1, 5, set);
            List<Job> randomList = new LinkedList<>();
            for(Integer id : set){
                randomList.add(jlist.get(id));
            }
            List<SolrItem> silist = new LinkedList<>();
            Iterator<Job> nit = randomList.iterator();
            Job njob;
            while(nit.hasNext()){
                SolrItem si = new SolrItem();
                njob = nit.next();
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
                CompanyExample.Criteria cc = companyExample.createCriteria();
                cc.andCompanyIdEqualTo(njob.getCompanyId());
                si.setCompanyName(companyMapper.selectByExample(companyExample).get(0).getCompanyName());
                silist.add(si);
            }

                return silist;
            } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (TasteException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean hasScored(User user) {
        UserJobRankExample validateExample = new UserJobRankExample();
        UserJobRankExample.Criteria validataCriteria = validateExample.createCriteria();
        validataCriteria.andUserIdEqualTo(user.getUserId());
        List<UserJobRank> ujrList = null;
        ujrList = userJobRankMapper.selectByExample(validateExample);
        //System.out.println("ujrList"+ujrList);
        return ujrList.size() == 0? false : true;
    }

    @Override
    /*
     user的education,professional
     user_job_intension的job_nature,job_name,salary,workplace
     和job的job_name,salary,education,workcity,job_nature还有company的company_industry进行比对
     */
    public String prescore(User user, UserJobIntension userJobIntension) throws Exception {
        Map<Integer,String> textMap = new HashMap();
        System.out.println("username: "+user.getUserName());

        Double grade = 0.0;
        int count = 0;
        int education = 0, professional = 0, jobNature = 0, jobName = 0, salary = 0, workplace = 0;
        int[] propVector = {education, professional, jobNature, jobName, salary, workplace};//初始属性向量
        Job job, job2;
        JobExample example = new JobExample();
        JobExample.Criteria criteria = example.createCriteria();
        criteria.andJobIdIsNotNull();
        example.setOrderByClause("job_id asc");
        List<Job> jobList = jobMapper.selectByExample(example);
        Iterator<Job> it = jobList.iterator();
        /*List<SolrItem> searchList;
        SolrItem solrItem;
        SearchResult searchResult = searchService.search(userJobIntension.getJobName(), 1l, 3179L);
        searchList = searchResult.getItemList();*//*
        JobExample jobExample = new JobExample();
        JobExample.Criteria criteria12 = jobExample.createCriteria();
        criteria12.andJobNameLike(userJobIntension.getJobName());
        List<Job> list = jobMapper.selectByExample(jobExample);
        Iterator<Job> iterator = list.iterator();*/

        while(it.hasNext()){
            job = it.next();

            propVector[0] = job.getEducation() <= user.getEducation()? 1 : 0;
            propVector[2] = job.getJobNature() == userJobIntension.getJobNature()? 1 : 0;
            propVector[4] = job.getSalaryMin() >= userJobIntension.getSalaryMin()? 1 : 0;
            propVector[5] = userJobIntension.getWorkplace().indexOf(job.getWorkcity()) != -1? 1 : 0;
            //-----------jobName匹配--------
            if(job.getJobName().contains(userJobIntension.getJobName()))propVector[3] = 1;

            /*while(iterator.hasNext()){
                job2 = iterator.next();
                if(){
                    propVector[3] = 1;
                    break;
                }
            }*/
            /*Iterator<SolrItem> sit = searchList.iterator();
            while(sit.hasNext()){
                solrItem = sit.next();
                System.out.println(solrItem.getJobId());
                //System.out.print("jobid:"+job.getJobId()+" "+"sjid:"+solrItem.getJobId()+":");
                if(solrItem.getCompanyId() == job.getCompanyId()){
                    System.out.print("jobid:"+job.getCompanyId()+" "+"sjid:"+solrItem.getCompanyId());
                    propVector[3] = 1;
                    break;
                }
                //System.out.println(propVector[3]);
            }*/
            //-------------------------------

            //--------professional匹配-----------
            CompanyExample companyExample = new CompanyExample();
            CompanyExample.Criteria criteria1 = companyExample.createCriteria();
            criteria1.andCompanyIdEqualTo(job.getCompanyId());
           //System.out.println("jobid:"+job.getJobId()+" "+companyMapper.selectByExample(companyExample).get(0).getCompanyIndustry()+" "+companyMapper.selectByExample(companyExample).get(0).getCompanyId()+user.getProfessional());
            propVector[1] = companyMapper.selectByExample(companyExample).get(0).getCompanyIndustry().contains(user.getProfessional()) ? 1 : 0;
            //System.out.println(propVector[1]);
            //-----------------------------------

            //textMap.put(job.getJobId(), "[" + propVector[0] + "," + propVector[1] + "," + propVector[2]
            //        + "," + propVector[3] + "," + propVector[4] + "," + propVector[5] + "]");
            UserJobRank record = new UserJobRank();
            record.setJobId(job.getJobId());
            record.setUserId(user.getUserId());
            for(int i = 0; i < 6; i++){
                if(propVector[i] == 1)count++;
            }
            //System.out.println(count);
            grade = 1 / (1 + Math.pow(E,-count));
            //textMap.put(job.getJobId(), String.valueOf(grade));
            record.setGrade(grade);
            if(count > 2) userJobRankMapper.insert(record);

            propVector[0] = 0;propVector[1] = 0;propVector[2] = 0;propVector[3] = 0;propVector[4] = 0;propVector[5] = 0;count = 0;

        }

        //return "UserId" + user.getUserId() + textMap.toString();
        return "prescore success";
    }
}

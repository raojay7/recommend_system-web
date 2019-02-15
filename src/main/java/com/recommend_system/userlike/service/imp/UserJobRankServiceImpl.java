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
import com.recommend_system.userlike.entity.UserLikeKey;
import com.recommend_system.userlike.service.UserJobRankService;
import com.recommend_system.userlike.service.UserLikeService;
import com.recommend_system.utils.JedisClient;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Autowired
    private UserLikeService userLikeService;
    @Autowired
    private JedisClient jc;

    @Override
    public void setScore(int uid, int jid, Double score) {
        UserJobRank record = new UserJobRank();
        record.setUserId(uid);
        record.setJobId(jid);
        record.setGrade(score);
        userJobRankMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Double getScore(int uid, int jid) {
        UserJobRankExample userJobRankExample = new UserJobRankExample();
        UserJobRankExample.Criteria criteria = userJobRankExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        criteria.andJobIdEqualTo(jid);
        List<UserJobRank> list = userJobRankMapper.selectByExample(userJobRankExample);
        Double score = list.size() == 0 ? 0.0 : list.get(0).getGrade();
        return score;
    }

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
    public List<SolrItem> recommend() {
        List<SolrItem> itemList = new LinkedList<>();
        if(jc.exists("recommend_list")){
            List<String> list = jc.getList("recommend_list");
            List<Integer> unduplicated = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            if(list.size() > 5){
                Random random = new Random();
                int count = 0;
                while(count < 5){
                    int randomIndex = random.nextInt(list.size());
                    if(!unduplicated.contains(randomIndex)){
                        unduplicated.add(randomIndex);
                        list2.add(list.get(randomIndex));
                        count++;
                    }
                }
            }
            for(int i = 0; i < list2.size(); i++){
                String info = list2.get(i);
                String[] properties = info.split(" ");
                SolrItem item = new SolrItem();

                item.setCompanyId(Integer.parseInt(properties[0]));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    item.setCtime(sdf.parse(properties[1]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                item.setEducation(Integer.parseInt(properties[2]));
                item.setJobName(properties[3]);
                item.setJobId(Integer.parseInt(properties[4]));
                item.setJobNature(Integer.parseInt(properties[5]));
                item.setNeedNum(Integer.parseInt(properties[6]));
                item.setSalaryMax(Integer.parseInt(properties[7]));
                item.setSalaryMin(Integer.parseInt(properties[8]));
                item.setSpecification(properties[9]);
                item.setWelfare(properties[10]);
                item.setWorkcity(properties[11]);
                item.setWorkexperienceMax(Integer.parseInt(properties[12]));
                item.setWorkexperienceMin(Integer.parseInt(properties[13]));
                item.setWorkplace(properties[14]);
                item.setCompanyName(properties[15]);

                itemList.add(item);

            }
        }
        else System.out.println("redis缓存为空！");
        return itemList;
    }

    @Override
    public void calculate(User user, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path))));
            UserJobRankExample example = new UserJobRankExample();
            UserJobRankExample.Criteria validataCriteria = example.createCriteria();
            validataCriteria.andGradeIsNotNull();
            List<UserJobRank> ujrList = userJobRankMapper.selectByExample(example);
            Iterator<UserJobRank> it = ujrList.iterator();
            UserJobRank userJobRank;
            String text;
            boolean collected;
            while(it.hasNext()){
                collected = false;
                userJobRank = it.next();
                int uid = userJobRank.getUserId();
                List<UserLikeKey> list = userLikeService.getList(uid);
                for(UserLikeKey ulk : list){
                    if(ulk.getJobId() == userJobRank.getJobId() && userJobRank.getGrade() < 4.5){
                        collected = true;
                        break;
                    }
                }
                text = userJobRank.getUserId() + "," + userJobRank.getJobId() + "," + (collected ? userJobRank.getGrade() + 0.5 : userJobRank.getGrade());
                bw.write(text);
                bw.newLine();
            }
            bw.close();

            //mahout推荐-------------------------------
            //基于项目的协同过滤
            /*DataModel dm = RecommendFactory.buildDataModel(path);
            ItemSimilarity is = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.CITYBLOCK, dm);
            RecommenderBuilder rb = RecommendFactory.itemRecommender(is, true);*/

            //-----结果评估----------
            //测试该方法平均绝对偏差
            //RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, rb, null, dm, 0.7);
            //测试该方法的Precision(相关的结果集/相关的+不相关的)和Recall(全部相关结果集中 检索到的/检索到的+未检索到的)
            //RecommendFactory.statsEvaluator(rb, null, dm, 2);

            //List<RecommendedItem> list = rb.buildRecommender(dm).recommend(user.getUserId(), 10);
            //基于用户的协同过滤
            DataModel dm = RecommendFactory.buildDataModel(path);
            UserSimilarity us = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dm);
            UserNeighborhood un = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.THRESHOLD, us, dm, 0.2);
            RecommenderBuilder rb = RecommendFactory.userRecommender(us, un, true);
            List<RecommendedItem> list = rb.buildRecommender(dm).recommend(user.getUserId(),10);

            //-----结果评估----------
            //测试该方法平均绝对偏差
            RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, rb, null, dm, 0.7);
            //测试该方法的Precision(相关的结果集/相关的+不相关的)和Recall(全部相关结果集中 检索到的/检索到的+未检索到的)
            RecommendFactory.statsEvaluator(rb, null, dm, 2);
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

                //filter
            UserJobIntensionExample userJobIntensionExample = new UserJobIntensionExample();
                UserJobIntensionExample.Criteria ujiCriteria = userJobIntensionExample.createCriteria();
                ujiCriteria.andUserIdEqualTo(user.getUserId());
                List<UserJobIntension> ujiList = userJobIntensionMapper.selectByExample(userJobIntensionExample);
                UserJobIntension userJobIntension = ujiList.get(0);

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
                        jlist.remove(valijob);
                    }
                }
            }
            for(int i = 0; i < jlist.size(); i++){
                Job job = jlist.get(i);
                String companyId = String.valueOf(job.getCompanyId());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String Ctime = sdf.format(job.getCtime());
                String education = String.valueOf(job.getEducation());
                String jobName = job.getJobName();
                String jobId = String.valueOf(job.getJobId());
                String jobNature = String.valueOf(job.getJobNature());
                String needNum = String.valueOf(job.getNeedNum());
                String salaryMax = String.valueOf(job.getSalaryMax());
                String salaryMin = String.valueOf(job.getSalaryMin());
                String specification = job.getSpecification();
                String welfare = job.getWelfare();
                String workcity = job.getWorkcity();
                String workExperienceMax = String.valueOf(job.getWorkexperienceMax());
                String workExperienceMin = String.valueOf(job.getWorkexperienceMin());
                String workPlace = job.getWorkplace();

                CompanyExample companyExample = new CompanyExample();
                CompanyExample.Criteria cc = companyExample.createCriteria();
                cc.andCompanyIdEqualTo(Integer.parseInt(companyId));
                String companyName = companyMapper.selectByExample(companyExample).get(0).getCompanyName();

                jc.appendRightList("recommend_list", companyId + " " + Ctime + " " + education + " " + jobName + " " + jobId + " " + jobNature + " " + needNum + " " +
                salaryMax + " " + salaryMin + " " + specification + " " + welfare + " " + workcity + " " + workExperienceMax + " " + workExperienceMin + " " + workPlace + " " + companyName);
            }
            //每次访问都随机取五个
            /*HashSet<Integer> set = fix HashSet<>();
            randomSet(0, jlist.size() - 1, 5, set);
            List<Job> randomList = fix LinkedList<>();
            for(Integer id : set){
                randomList.add(jlist.get(id));
            }
            List<SolrItem> silist = fix LinkedList<>();
            Iterator<Job> nit = randomList.iterator();
            Job njob;
            while(nit.hasNext()){
                SolrItem si = fix SolrItem();
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
                CompanyExample companyExample = fix CompanyExample();
                CompanyExample.Criteria cc = companyExample.createCriteria();
                cc.andCompanyIdEqualTo(njob.getCompanyId());
                si.setCompanyName(companyMapper.selectByExample(companyExample).get(0).getCompanyName());
                silist.add(si);
            }

                return silist;*/
            } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (TasteException e1) {
            e1.printStackTrace();
        }
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

        while(it.hasNext()){
            job = it.next();

            propVector[0] = job.getEducation() <= user.getEducation()? 1 : 0;
            propVector[2] = job.getJobNature() == userJobIntension.getJobNature()? 1 : 0;
            propVector[4] = job.getSalaryMin() >= userJobIntension.getSalaryMin()? 1 : 0;
            propVector[5] = userJobIntension.getWorkplace().indexOf(job.getWorkcity()) != -1? 1 : 0;
            //-----------jobName匹配--------
            if(job.getJobName().contains(userJobIntension.getJobName()))propVector[3] = 1;


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
            if(count > 3) userJobRankMapper.insert(record);

            propVector[0] = 0;propVector[1] = 0;propVector[2] = 0;propVector[3] = 0;propVector[4] = 0;propVector[5] = 0;count = 0;

        }

        //return "UserId" + user.getUserId() + textMap.toString();
        return "prescore success";
    }
}

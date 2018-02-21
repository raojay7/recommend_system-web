package com.recommend_system.job.service.imp;

import com.recommend_system.company.entity.CompanyExt;
import com.recommend_system.job.dao.JobMapper;
import com.recommend_system.job.entity.JobExt;
import com.recommend_system.job.service.JobEchartsService;
import com.recommend_system.utils.JedisClient;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

@Service
public class JobEchartsServiceImpl implements JobEchartsService{

    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private JedisClient jc;


    @Override
    public String getCityAvgSalary() {
        if(jc.exists("cityavgsalary_city") && jc.exists("cityavgsalary_avg")){
            List<String> city = jc.getList("cityavgsalary_city");
            List<String> avg = jc.getList("cityavgsalary_avg");

            Iterator<String> it_city = city.iterator();
            Iterator<String> it_avg = avg.iterator();

            JSONObject jsonObject = new JSONObject();
            //标题对象
            JSONObject titleObject = new JSONObject();
            titleObject.put("text", "城市平均工资分布");
            jsonObject.put("title", titleObject);
            //文字提示框对象
            JSONObject tooltipsObj = new JSONObject();
            tooltipsObj.put("trigger", "axis");
            tooltipsObj.put("label", "工资");
            jsonObject.put("tooltip", tooltipsObj);
            //各线说明
            JSONObject legendObj = new JSONObject();
            legendObj.put("data", new JSONArray().add("工资"));
            jsonObject.put("legend", legendObj);
            //y轴，一般空
            jsonObject.put("yAxis", new JSONObject());

            JSONObject xObj = new JSONObject();
            JSONArray seArr = new JSONArray();

            JSONObject seObj = new JSONObject();
            seObj.put("name", "工资");
            seObj.put("type", "bar");

            JSONObject gridObject = new JSONObject();
            gridObject.put("y2", 150);

            JSONArray xDataArr = new JSONArray();
            JSONArray seDataArr = new JSONArray();

            while(it_city.hasNext() && it_avg.hasNext()){
                xDataArr.add(it_city.next());
                seDataArr.add(Double.parseDouble(it_avg.next()));
            }
            xObj.put("data", xDataArr);
            seObj.put("data",seDataArr);
            seArr.add(seObj);
            JSONObject alobj = new JSONObject();
            alobj.put("interval",0);
            alobj.put("rotate",45);
            alobj.put("margin",5);
            xObj.put("axisLabel",alobj);
            jsonObject.put("xAxis", xObj);
            jsonObject.put("series", seArr);//series是对象数组，所以用seArr存几个对象，每个对象有name,type,data[]
            jsonObject.put("grid", gridObject);

            return jsonObject.toString();
        }else {
            JobExt je;
            List<JobExt> list = jobMapper.getCityAvgSalary();
            Iterator<JobExt> it = list.iterator();
            while(it.hasNext()){
                je = it.next();
                jc.appendRightList("cityavgsalary_city", je.getWorkcity());
                jc.appendRightList("cityavgsalary_avg",String.valueOf(je.getAve_salary()));
            }
            return getCityAvgSalary();
        }
    }

    @Override
    public String getEducationAvgSalary() {
        if(jc.exists("educationavgsalary_education") && jc.exists("educationavgsalary_avg") && jc.exists("educationavgsalary_jobnum")){
            List<String> education = jc.getList("educationavgsalary_education");
            List<String> avg = jc.getList("educationavgsalary_avg");
            List<String> jobnum = jc.getList("educationavgsalary_jobnum");

            Iterator<String> it_education = education.iterator();
            Iterator<String> it_avg = avg.iterator();
            Iterator<String> it_jobnum = jobnum.iterator();

            JSONObject jsonObject = new JSONObject();
            //标题对象
            JSONObject titleObject = new JSONObject();
            titleObject.put("text", "学历平均工资及岗位需求量分布");
            jsonObject.put("title", titleObject);
            //文字提示框对象
            JSONObject tooltipsObj = new JSONObject();
            tooltipsObj.put("trigger", "axis");
            tooltipsObj.put("label", "平均工资*10");
            jsonObject.put("tooltip", tooltipsObj);
            //各线说明
            JSONObject legendObj = new JSONObject();
            JSONArray lgd = new JSONArray();
            lgd.add("需求量");
            lgd.add("平均工资*10");
            legendObj.put("data", lgd);
            jsonObject.put("legend", legendObj);
            //y轴，一般空
            jsonObject.put("yAxis", new JSONObject());

            JSONObject xObj = new JSONObject();
            JSONArray seArr = new JSONArray();

            JSONObject seObj = new JSONObject();
            seObj.put("name", "需求量");
            seObj.put("type", "bar");
            JSONObject seObj2 = new JSONObject();
            seObj2.put("name","平均工资*10");
            seObj2.put("type","line");
            JSONArray dataArr2 = new JSONArray();


            JSONObject gridObject = new JSONObject();
            gridObject.put("y2", 150);

            JSONArray xDataArr = new JSONArray();
            JSONArray seDataArr = new JSONArray();

            DecimalFormat df = new DecimalFormat("0.000");

            while(it_education.hasNext() && it_avg.hasNext() && it_jobnum.hasNext()){
                xDataArr.add(it_education.next());
                dataArr2.add(Double.parseDouble(df.format(Double.parseDouble(it_avg.next())/10)));
                seDataArr.add(Integer.parseInt(it_jobnum.next()));
            }
            xObj.put("data", xDataArr);
            seObj.put("data",seDataArr);
            seObj2.put("data",dataArr2);
            seArr.add(seObj);
            seArr.add(seObj2);
            jsonObject.put("xAxis", xObj);
            jsonObject.put("series", seArr);//series是对象数组，所以用seArr存几个对象，每个对象有name,type,data[]
            jsonObject.put("grid", gridObject);

            return jsonObject.toString();
        }else {
            JobExt je;
            List<JobExt> list = jobMapper.getEducationAvgSalary();
            Iterator<JobExt> it = list.iterator();
            int edu;
            String s;
            while(it.hasNext()){
                je = it.next();
                edu = je.getEducation();
                switch (edu){
                    case 0:
                        s = "大专及以下";
                        break;
                    case 1:
                        s = "本科";
                        break;
                    case 2:
                        s = "硕士";
                        break;
                    case 3:
                        s = "博士";
                        break;
                        default:
                            s = "本科";
                            break;
                }
                jc.appendRightList("educationavgsalary_education",s);
                jc.appendRightList("educationavgsalary_jobnum",String.valueOf(je.getJobnum()));
                jc.appendRightList("educationavgsalary_avg",String.valueOf(je.getAve_salary()));
            }
            return getEducationAvgSalary();
        }
    }

    @Override
    public String getJobCity() {
        if(jc.exists("jobcity_city") && jc.exists("jobcity_jobnum")){
            List<String> city = jc.getList("jobcity_city");
            List<String> jobnum = jc.getList("jobcity_jobnum");

            JSONArray data = new JSONArray();
            Iterator<String> it_city = city.iterator();
            Iterator<String> it_jobnum = jobnum.iterator();
            String name,value;
            while(it_city.hasNext() && it_jobnum.hasNext()){
                JSONObject ele = new JSONObject();
                name = it_city.next();
                value = it_jobnum.next();
                ele.put("name", name);
                ele.put("value",Integer.parseInt(value));
                data.add(ele);
            }
            return data.toString();
        }else {
            JobExt je;
            List<JobExt> list = jobMapper.getJobCity();
            Iterator<JobExt> it = list.iterator();
            while(it.hasNext()){
                je = it.next();
                jc.appendRightList("jobcity_city", je.getWorkcity());
                jc.appendRightList("jobcity_jobnum",String.valueOf(je.getJobnum()));
            }
            return getJobCity();
        }
    }

    @Override
    public String getExperienceSalary() {
        if(jc.exists("workex_ex") && jc.exists("workex_avg")){
            List<String> ex = jc.getList("workex_ex");
            List<String> avg = jc.getList("workex_avg");

            Iterator<String> it_ex = ex.iterator();
            Iterator<String> it_avg = avg.iterator();

            JSONObject jsonObject = new JSONObject();
            //标题对象
            JSONObject titleObject = new JSONObject();
            titleObject.put("text", "工作经验对应工资分布");
            jsonObject.put("title", titleObject);
            //文字提示框对象
            JSONObject tooltipsObj = new JSONObject();
            tooltipsObj.put("trigger", "axis");
            tooltipsObj.put("label", "工作经验");
            jsonObject.put("tooltip", tooltipsObj);
            //各线说明
            JSONObject legendObj = new JSONObject();
            JSONArray lgd = new JSONArray();
            lgd.add("工资");
            legendObj.put("data", lgd);
            jsonObject.put("legend", legendObj);
            //y轴，一般空
            jsonObject.put("yAxis", new JSONObject());

            JSONObject xObj = new JSONObject();
            JSONArray seArr = new JSONArray();

            JSONObject seObj = new JSONObject();
            seObj.put("name", "工资");
            seObj.put("type", "bar");

            JSONObject gridObject = new JSONObject();
            gridObject.put("y2", 150);

            JSONArray xDataArr = new JSONArray();
            JSONArray seDataArr = new JSONArray();

            DecimalFormat df = new DecimalFormat("0.000");

            while(it_ex.hasNext() && it_avg.hasNext()){
                xDataArr.add(it_ex.next());
                seDataArr.add(Double.parseDouble(df.format(Double.parseDouble(it_avg.next()))));
            }
            xObj.put("data", xDataArr);
            seObj.put("data",seDataArr);
            seArr.add(seObj);
            jsonObject.put("xAxis", xObj);
            jsonObject.put("series", seArr);//series是对象数组，所以用seArr存几个对象，每个对象有name,type,data[]
            jsonObject.put("grid", gridObject);

            return jsonObject.toString();
        }else {
            JobExt je;
            List<JobExt> list = jobMapper.getExperienceSalary();
            Iterator<JobExt> it = list.iterator();
            int ex_max, ex_min;
            String s;
            while(it.hasNext()){
                je = it.next();
                ex_max = je.getWorkexperience_max();
                ex_min = je.getWorkexperience_min();
                if(ex_min == 1 && ex_max == 3){
                    s = "1到3年";
                }else if(ex_min == 3 && ex_max == 5){
                    s = "3到5年";
                }else{
                    s = "5到10年";
                }
                jc.appendRightList("workex_ex",s);
                jc.appendRightList("workex_avg",String.valueOf(je.getAve_salary()));
            }
            return getExperienceSalary();
        }
    }
}

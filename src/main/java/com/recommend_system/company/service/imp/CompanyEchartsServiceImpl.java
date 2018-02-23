package com.recommend_system.company.service.imp;

import com.recommend_system.company.dao.CompanyMapper;
import com.recommend_system.company.entity.CompanyExt;
import com.recommend_system.company.service.CompanyEchartsService;
import com.recommend_system.utils.JedisClient;
import com.recommend_system.utils.impl.JedisClientPool;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class CompanyEchartsServiceImpl implements CompanyEchartsService{

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    JedisClient jc;

    @Override
    public String getCompanyCity() {
        if(jc.exists("companycity_city") && jc.exists("companycity_jobnum")){
            List<String> city = jc.getList("companycity_city");
            List<String> jobnum = jc.getList("companycity_jobnum");

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
            CompanyExt ce;
            List<CompanyExt> list = companyMapper.getCompanyCity();
            Iterator<CompanyExt> it = list.iterator();
            while(it.hasNext()){
                ce = it.next();
                jc.appendRightList("companycity_city", ce.getCity());
                jc.appendRightList("companycity_jobnum",String.valueOf(ce.getJobnum()));
            }
            return getCompanyCity();
        }
    }

    @Override
    public String getCompanyIndustry() {
        if(jc.exists("companyindustry_industry") && jc.exists("companyindustry_jobnum")){
            List<String> industry = jc.getList("companyindustry_industry");
            List<String> jobnum = jc.getList("companyindustry_jobnum");

            Iterator<String> it_industry = industry.iterator();
            Iterator<String> it_jobnum = jobnum.iterator();

            JSONObject jsonObject = new JSONObject();
            //标题对象
            JSONObject titleObject = new JSONObject();
            titleObject.put("text", "公司行业分布");
            jsonObject.put("title", titleObject);
            //文字提示框对象
            JSONObject tooltipsObj = new JSONObject();
            tooltipsObj.put("trigger", "axis");
            tooltipsObj.put("label", "行业");
            jsonObject.put("tooltip", tooltipsObj);
            //各线说明
            JSONObject legendObj = new JSONObject();
            JSONArray lgd = new JSONArray();
            lgd.add("行业");
            legendObj.put("data", lgd);
            jsonObject.put("legend", legendObj);
            //y轴，一般空
            jsonObject.put("yAxis", new JSONObject());

            JSONObject xObj = new JSONObject();
            JSONArray seArr = new JSONArray();

            JSONObject seObj = new JSONObject();
            seObj.put("name", "公司数量");
            seObj.put("type", "bar");

            JSONObject alobj = new JSONObject();
            alobj.put("interval",0);
            alobj.put("rotate",45);
            alobj.put("margin",5);

            JSONObject gridObject = new JSONObject();
            gridObject.put("y2", 150);

            JSONArray xDataArr = new JSONArray();
            JSONArray seDataArr = new JSONArray();

            while(it_industry.hasNext() && it_jobnum.hasNext()){
                xDataArr.add(it_industry.next());
                seDataArr.add(Integer.parseInt(it_jobnum.next()));
            }
            xObj.put("data", xDataArr);
            xObj.put("axisLabel",alobj);
            seObj.put("data",seDataArr);
            seArr.add(seObj);
            jsonObject.put("xAxis", xObj);
            jsonObject.put("series", seArr);//series是对象数组，所以用seArr存几个对象，每个对象有name,type,data[]
            jsonObject.put("grid", gridObject);

            return jsonObject.toString();
        }else {
            CompanyExt ce;
            List<CompanyExt> list = companyMapper.getCompanyIndustry();
            Iterator<CompanyExt> it = list.iterator();
            while(it.hasNext()){
                ce = it.next();
                jc.appendRightList("companyindustry_industry", ce.getCompany_industry());
                jc.appendRightList("companyindustry_jobnum",String.valueOf(ce.getJobnum()));
            }
            return getCompanyIndustry();
        }
    }

    @Override
    public String getCompanyNature() {
        if(jc.exists("companynature_nature") && jc.exists("companynature_jobnum")){
            List<String> industry = jc.getList("companynature_nature");
            List<String> jobnum = jc.getList("companynature_jobnum");

            Iterator<String> it_nature = industry.iterator();
            Iterator<String> it_jobnum = jobnum.iterator();

            JSONObject jsonObject = new JSONObject();
            //标题对象
            JSONObject titleObject = new JSONObject();
            titleObject.put("text", "公司性质分布");
            jsonObject.put("title", titleObject);
            //文字提示框对象
            JSONObject tooltipsObj = new JSONObject();
            tooltipsObj.put("trigger", "axis");
            tooltipsObj.put("label", "性质");
            jsonObject.put("tooltip", tooltipsObj);
            //各线说明
            JSONObject legendObj = new JSONObject();
            legendObj.put("data", new JSONArray().add("性质"));
            jsonObject.put("legend", legendObj);
            //y轴，一般空
            jsonObject.put("yAxis", new JSONObject());

            JSONObject xObj = new JSONObject();
            JSONArray seArr = new JSONArray();

            JSONObject seObj = new JSONObject();
            seObj.put("name", "性质");
            seObj.put("type", "bar");

            JSONObject gridObject = new JSONObject();
            gridObject.put("y2", 150);

            JSONArray xDataArr = new JSONArray();
            JSONArray seDataArr = new JSONArray();

            while(it_nature.hasNext() && it_jobnum.hasNext()){
                xDataArr.add(it_nature.next());
                seDataArr.add(Integer.parseInt(it_jobnum.next()));
            }
            xObj.put("data", xDataArr);
            seObj.put("data",seDataArr);
            seArr.add(seObj);
            jsonObject.put("xAxis", xObj);
            jsonObject.put("series", seArr);//series是对象数组，所以用seArr存几个对象，每个对象有name,type,data[]
            jsonObject.put("grid", gridObject);

            return jsonObject.toString();
        }else {
            CompanyExt ce;
            List<CompanyExt> list = companyMapper.getCompanyNature();
            Iterator<CompanyExt> it = list.iterator();
            while(it.hasNext()){
                ce = it.next();
                jc.appendRightList("companynature_nature", ce.getCompany_nature());
                jc.appendRightList("companynature_jobnum",String.valueOf(ce.getJobnum()));
            }
            return getCompanyNature();
        }
    }

    @Override
    public String getCompanyScale() {
        if(jc.exists("companyscale_scale") && jc.exists("companyscale_jobnum")){
            List<String> scale = jc.getList("companyscale_scale");
            List<String> jobnum = jc.getList("companyscale_jobnum");

            Iterator<String> it_scale = scale.iterator();
            Iterator<String> it_jobnum = jobnum.iterator();

            JSONObject jsonObject = new JSONObject();
            //标题对象
            JSONObject titleObject = new JSONObject();
            titleObject.put("text", "公司规模分布");
            jsonObject.put("title", titleObject);
            //文字提示框对象
            JSONObject tooltipsObj = new JSONObject();
            tooltipsObj.put("trigger", "axis");
            tooltipsObj.put("label", "规模");
            jsonObject.put("tooltip", tooltipsObj);
            //各线说明
            JSONObject legendObj = new JSONObject();
            legendObj.put("data", new JSONArray().add("规模"));
            jsonObject.put("legend", legendObj);
            //y轴，一般空
            jsonObject.put("yAxis", new JSONObject());

            JSONObject xObj = new JSONObject();
            JSONArray seArr = new JSONArray();

            JSONObject seObj = new JSONObject();
            seObj.put("name", "规模");
            seObj.put("type", "bar");

            JSONObject gridObject = new JSONObject();
            gridObject.put("y2", 150);

            JSONArray xDataArr = new JSONArray();
            JSONArray seDataArr = new JSONArray();

            while(it_scale.hasNext() && it_jobnum.hasNext()){
                xDataArr.add(it_scale.next());
                seDataArr.add(Integer.parseInt(it_jobnum.next()));
            }
            xObj.put("data", xDataArr);
            seObj.put("data",seDataArr);
            seArr.add(seObj);
            jsonObject.put("xAxis", xObj);
            jsonObject.put("series", seArr);//series是对象数组，所以用seArr存几个对象，每个对象有name,type,data[]
            jsonObject.put("grid", gridObject);

            return jsonObject.toString();
        }else {
            CompanyExt ce;
            List<CompanyExt> list = companyMapper.getCompanyScale();
            Iterator<CompanyExt> it = list.iterator();
            while(it.hasNext()){
                ce = it.next();
                jc.appendRightList("companyscale_scale", ce.getCompany_scale());
                jc.appendRightList("companyscale_jobnum",String.valueOf(ce.getJobnum()));
            }
            return getCompanyScale();
        }
    }

    @Override
    public String getCompanyNatureNeedAvg() {
        if(jc.exists("companyntna_nature") && jc.exists("companyntna_jobnum") && jc.exists("companyntna_avg")){
            List<String> nature = jc.getList("companyntna_nature");
            List<String> jobnum = jc.getList("companyntna_jobnum");
            List<String> avg = jc.getList("companyntna_avg");

            Iterator<String> it_nature = nature.iterator();
            Iterator<String> it_jobnum = jobnum.iterator();
            Iterator<String> it_avg = avg.iterator();

            JSONObject jsonObject = new JSONObject();
            //标题对象
            JSONObject titleObject = new JSONObject();
            titleObject.put("text", "不同性质公司平均工资及需求量分布");
            jsonObject.put("title", titleObject);
            //文字提示框对象
            JSONObject tooltipsObj = new JSONObject();
            tooltipsObj.put("trigger", "axis");
            tooltipsObj.put("label", "平均工资");
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

            String n,j,a;

            DecimalFormat df = new DecimalFormat("0.000");

            while(it_nature.hasNext() && it_jobnum.hasNext() && it_avg.hasNext()){
                n = it_nature.next();
                j = it_jobnum.next();
                a = it_avg.next();
                xDataArr.add(n);
                seDataArr.add(Integer.parseInt(j));
                dataArr2.add(Double.parseDouble(df.format(Double.parseDouble(a)/10)));
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
            CompanyExt ce;
            List<CompanyExt> list = companyMapper.getCompanyNatureNeedAvg();
            Iterator<CompanyExt> it = list.iterator();
            while(it.hasNext()){
                ce = it.next();
                jc.appendRightList("companyntna_nature", ce.getCompany_nature());
                jc.appendRightList("companyntna_jobnum",String.valueOf(ce.getJobnum()));
                jc.appendRightList("companyntna_avg",String.valueOf(ce.getAve_salary()));
            }
            return getCompanyNatureNeedAvg();
        }
    }

    @Override
    public String getCompanyIndustryNeedAvg() {
        if(jc.exists("companyina_industry") && jc.exists("companyina_jobnum") && jc.exists("companyina_avg")){
            List<String> industry = jc.getList("companyina_industry");
            List<String> jobnum = jc.getList("companyina_jobnum");
            List<String> avg = jc.getList("companyina_avg");

            Iterator<String> it_industry = industry.iterator();
            Iterator<String> it_jobnum = jobnum.iterator();
            Iterator<String> it_avg = avg.iterator();

            JSONObject jsonObject = new JSONObject();
            //标题对象
            JSONObject titleObject = new JSONObject();
            titleObject.put("text", "不同行业平均工资及需求量分布");
            jsonObject.put("title", titleObject);
            //文字提示框对象
            JSONObject tooltipsObj = new JSONObject();
            tooltipsObj.put("trigger", "axis");
            tooltipsObj.put("label", "平均工资");
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

            String n,j,a;

            DecimalFormat df = new DecimalFormat("0.000");

            while(it_industry.hasNext() && it_jobnum.hasNext() && it_avg.hasNext()){
                n = it_industry.next();
                j = it_jobnum.next();
                a = it_avg.next();
                xDataArr.add(n);
                seDataArr.add(Integer.parseInt(j));
                dataArr2.add(Double.parseDouble(df.format(Double.parseDouble(a)/10)));
            }


            xObj.put("data", xDataArr);
            seObj.put("data",seDataArr);
            seObj2.put("data",dataArr2);
            seArr.add(seObj);
            seArr.add(seObj2);
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
            CompanyExt ce;
            List<CompanyExt> list = companyMapper.getCompanyIndustryNeedAvg();
            Iterator<CompanyExt> it = list.iterator();
            while(it.hasNext()){
                ce = it.next();
                jc.appendRightList("companyina_industry", ce.getCompany_industry());
                jc.appendRightList("companyina_jobnum",String.valueOf(ce.getJobnum()));
                jc.appendRightList("companyina_avg",String.valueOf(ce.getAve_salary()));
            }
            return getCompanyIndustryNeedAvg();
        }
    }
}

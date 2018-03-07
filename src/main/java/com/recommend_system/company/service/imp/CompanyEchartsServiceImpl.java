package com.recommend_system.company.service.imp;

import com.recommend_system.company.dao.CompanyMapper;
import com.recommend_system.company.entity.CompanyExample;
import com.recommend_system.company.entity.CompanyExt;
import com.recommend_system.company.service.CompanyEchartsService;
import com.recommend_system.utils.DataFilter;
import com.recommend_system.utils.JedisClient;
import com.recommend_system.utils.impl.SortFilter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class CompanyEchartsServiceImpl implements CompanyEchartsService {

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
            gridObject.put("x", 50);

            JSONArray xDataArr = new JSONArray();
            JSONArray seDataArr = new JSONArray();

            while(it_industry.hasNext() && it_jobnum.hasNext()){
                xDataArr.add(it_industry.next());
                seDataArr.add(it_jobnum.next());
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
            /*CompanyExt ce;
            List<CompanyExt> list = companyMapper.getCompanyIndustry();
            Iterator<CompanyExt> it = list.iterator();
            while(it.hasNext()){
                ce = it.next();
                jc.appendRightList("companyindustry_industry", ce.getCompany_industry());
                jc.appendRightList("companyindustry_jobnum",String.valueOf(ce.getJobnum()));
            }*/
            DataFilter dataFilter = new SortFilter();
            dataFilter.sort_filter2(companyMapper.getCompanyIndustry(),1f, jc, "companyindustry_industry", "companyindustry_jobnum");
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
            gridObject.put("y2", 30);
            gridObject.put("x",45);

            JSONArray xDataArr = new JSONArray();
            JSONArray seDataArr = new JSONArray();

            while(it_nature.hasNext() && it_jobnum.hasNext()){

                xDataArr.add(it_nature.next());
                seDataArr.add(it_jobnum.next());
            }
            xObj.put("data", xDataArr);
            seObj.put("data",seDataArr);
            seArr.add(seObj);
            jsonObject.put("xAxis", xObj);
            jsonObject.put("series", seArr);//series是对象数组，所以用seArr存几个对象，每个对象有name,type,data[]
            jsonObject.put("grid", gridObject);

            return jsonObject.toString();
        }else {
            /*CompanyExt ce;
            List<CompanyExt> list = companyMapper.getCompanyNature();
            Iterator<CompanyExt> it = list.iterator();
            while(it.hasNext()){
                ce = it.next();
                jc.appendRightList("companynature_nature", ce.getCompany_nature());
                jc.appendRightList("companynature_jobnum",String.valueOf(ce.getJobnum()));
            }*/
            DataFilter dataFilter = new SortFilter();
            dataFilter.sort_filter3(companyMapper.getCompanyNature(),1f, jc, "companynature_nature", "companynature_jobnum");
            return getCompanyNature();
        }
    }

    @Override
    public String getCompanyScale(int type) {
        if(jc.exists("companyscale_industry")){
            List<String> industry = jc.getList("companyscale_industry");



            JSONArray ja;
            if(type == 2){
                System.out.println("type=2");
                ja = new JSONArray();
                ja.add("100-499人");
                ja.add("1000-9999人");
                ja.add("10000人以上");
                ja.add("20-99人");
                ja.add("20人以下");
                ja.add("500-999人");
                ja.add("保密");
                System.out.println(ja.toString());
                return ja.toString();
            }else if(type == 1){
                System.out.println("type=1");
                Iterator<String> it_industry = industry.iterator();
                ja = new JSONArray();
                while(it_industry.hasNext()) {
                    ja.add(it_industry.next());
                }
                System.out.println(ja.toString());
                return ja.toString();
            }else if(type == 3){
                System.out.println("type=3");
                Iterator<String> it_industry = industry.iterator();
                JSONObject jo;

                //label的json对象，固定的
                JSONObject label = new JSONObject();
                JSONObject normal = new JSONObject();
                normal.put("show", true);
                normal.put("position", "insideRight");
                label.put("normal", normal);

                //每个行业都要一个joObject,最后返回joObject的数组
                JSONArray objDataArr = new JSONArray();
                while(it_industry.hasNext()){
                    String cids = it_industry.next();
                    System.out.println("_"+cids+"_");
                    JSONArray dataArr = new JSONArray();

                    Map<String, Integer> map = new LinkedHashMap<>();
                    map.put("100-499人", 0);//先建立好初始的当前行业所对应的<规模,数量>map
                    map.put("1000-9999人", 0);
                    map.put("10000人以上", 0);
                    map.put("20-99人", 0);
                    map.put("20人以下", 0);
                    map.put("500-999人", 0);
                    map.put("保密", 0);

                    //初始map建立好后开始sql语句查，查出来的对应的行业，对应map数量加上
                    //加完后提取出数量数组即可
                    List<CompanyExt> clist = companyMapper.getCompanyScale(cids);
                    Iterator<CompanyExt> cit = clist.iterator();
                    CompanyExt ce;
                    int num = 0;
                    while(cit.hasNext()){
                        ce = cit.next();
                        //System.out.println(ce.getCompany_scale());
                        if(map.containsKey(ce.getCompany_scale())){
                            num = map.get(ce.getCompany_scale());
                            num +=ce.getJobnum();
                        }


                        map.put(ce.getCompany_scale(), num);
                    }

                    for(Map.Entry<String, Integer> entry : map.entrySet()){
                        dataArr.add(entry.getValue());
                    }


                    jo = new JSONObject();
                    jo.put("name", cids);
                    jo.put("type", "bar");
                    jo.put("stack", "总量");
                    jo.put("label", label);
                    jo.put("data", dataArr);

                    objDataArr.add(jo);
                }
                    //System.out.println(objDataArr.toString());
                    //开始筛选，前十个最大的obj
                    String text;
                    int total = 0;
                    Map<Integer, Integer> smap = new TreeMap<>();
                    Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer,Integer>>() {
                        @Override
                        public int compare(Map.Entry<Integer, Integer> o1,
                                           Map.Entry<Integer, Integer> o2) {
                            return o1.getValue()-o2.getValue();
                        }
                    };
                    for(int i = 0; i < objDataArr.size(); i++){
                        text = objDataArr.get(i).toString();
                        text = text.substring(text.indexOf("[") + 1, text.indexOf("]") - 1);
                        //System.out.println(text);
                        String[] nums = text.split(",");
                        //System.out.println(nums[0] + nums[1] + nums[2] + nums[3] + nums[4] + nums[5] + nums[6]);
                        total += (Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]) + Integer.parseInt(nums[2]) + Integer.parseInt(nums[3]) + Integer.parseInt(nums[4]) + Integer.parseInt(nums[5]));
                        smap.put(i, total);
                        //System.out.println(total);
                        total = 0;
                    }
                    List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(smap.entrySet());
                    Collections.sort(list, valueComparator);
                    int count  = 0;
                    //System.out.println("objsize:" + objDataArr.size());
                    //System.out.println("listsize:" + list.size());
                    JSONArray mtoarr = new JSONArray();
                    for(Map.Entry<Integer, Integer> entry : list){
                        count++;
                        if(count > objDataArr.size() - 10){
                            mtoarr.add(objDataArr.get(entry.getKey()));
                        }
                    }


                //System.out.println("final size:" + mtoarr.size());
                return mtoarr.toString();
            }



        }else {
            CompanyExt ce;
            List<CompanyExt> list2  = companyMapper.getCompanyIndustry();
            Iterator<CompanyExt> it2 = list2.iterator();
            while(it2.hasNext()){
                ce = it2.next();
                jc.appendRightList("companyscale_industry", ce.getCompany_industry());
            }
            return getCompanyScale(type);
        }
        return null;
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
            gridObject.put("y2", 20);
            gridObject.put("x",50);

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
            gridObject.put("x",110);

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

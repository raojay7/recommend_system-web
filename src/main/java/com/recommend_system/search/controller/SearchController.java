package com.recommend_system.search.controller;

import com.recommend_system.search.service.SearchService;
import com.recommend_system.user.entity.User;
import com.recommend_system.user.entity.UserJobIntension;
import com.recommend_system.uservisit.entity.VisitJob;
import com.recommend_system.uservisit.service.UserVisitService;
import com.taotao.common.pojo.Layui;
import com.taotao.common.pojo.SolrItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.SearchResult;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	@Autowired
	private UserVisitService userVisitService;

	@RequestMapping("/q")
	@ResponseBody
	public Layui search(HttpSession session, @RequestParam("kw")String queryString, @RequestParam(defaultValue="1")Long page, @RequestParam(defaultValue="30")Long limit)
	{
		System.out.println("进入了search方法");
		if (StringUtils.isBlank(queryString))
		{
			//return TaotaoResult.build(400, "查询条件不能为空");
			session.setAttribute("search", "");
			return Layui.data((long)0, null);
		}
		try
		{
			//解决get乱码问题
			queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			SearchResult searchResult = searchService.search(queryString, page, limit, true);
			session.setAttribute("search", queryString);
			return Layui.data(searchResult.getTotal(), searchResult.getItemList());
			//return TaotaoResult.ok(searchResult);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			session.setAttribute("search", "");
			//return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
			return Layui.data((long)0, null);
		}

	}

	@RequestMapping("moreIikeByItem")
	@ResponseBody
	public Layui  moreIikeByItem(SolrItem item, HttpSession session) throws Exception{
		//解决get乱码问题
		//queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
		//SearchResult searchResult = searchService.search(queryString, page, limit);
		User user = (User)session.getAttribute("user");
		UserJobIntension userJobIntension = (UserJobIntension)session.getAttribute("uji");
		if(userVisitService.isEmpty(user.getUserId())){
			System.out.println("用户浏览记录为空");
			SearchResult searchResult = searchService.search(userJobIntension.getJobName(), 1l, 10l, false);
			return Layui.data(searchResult.getTotal(), searchResult.getItemList());
		}else {
			List<VisitJob> vlist2 = userVisitService.getRecentVisit(user.getUserId());
			List<VisitJob> vlist = new LinkedList<>();
			System.out.println("vlist2.size = " + vlist2.size());
			int vsize = vlist2.size();
			if(vsize > 3){
				Random random = new Random();
				int validNum = 0, randomNum;
				List<Integer> removeNumList = new LinkedList<>();
				while(validNum != 3){
					randomNum = random.nextInt(vsize);
					if(!removeNumList.contains(randomNum)){
						System.out.println("randomNum" + randomNum);
						validNum++;
						removeNumList.add(randomNum);
					}
				}
				vlist.add(vlist2.get(removeNumList.get(0)));
				vlist.add(vlist2.get(removeNumList.get(1)));
				vlist.add(vlist2.get(removeNumList.get(2)));

			}else{
				vlist.addAll(vlist2);
			}
			Iterator<VisitJob> it = vlist.iterator();
			List<SearchResult> resultList = new LinkedList<>();
			while(it.hasNext()){
				int visitId = it.next().gettJobId();
				item = new SolrItem();
				item.setJobId(visitId);
				SearchResult searchResult = searchService.moreIikeByItem(item);
				resultList.add(searchResult);
			}
			Iterator<SearchResult> srit = resultList.iterator();
			List<SolrItem> finalList = new LinkedList<>();
			while(srit.hasNext()){
				SearchResult searchResult = srit.next();
				List<SolrItem> tempList = searchResult.getItemList();
				int temp = 0, count = 0;
				while(count != 3) {
					SolrItem tempsi = tempList.get(temp);
					if(tempsi.getEducation() <= user.getEducation() && tempsi.getSalaryMin() >= userJobIntension.getSalaryMin()) {
						finalList.add(tempList.get(temp));
						count++;
					}
					temp++;
				}
			}
			if(vsize == 1){
				SearchResult searchResult = searchService.search(userJobIntension.getJobName(), 1l, 10l, false);
				finalList.add(searchResult.getItemList().get(0));
				finalList.add(searchResult.getItemList().get(1));
				finalList.add(searchResult.getItemList().get(2));
				finalList.add(searchResult.getItemList().get(3));
				finalList.add(searchResult.getItemList().get(4));
				finalList.add(searchResult.getItemList().get(5));
			}else if(vsize == 2){
				SearchResult searchResult = searchService.search(userJobIntension.getJobName(), 1l, 10l, false);
				finalList.add(searchResult.getItemList().get(0));
				finalList.add(searchResult.getItemList().get(1));
				finalList.add(searchResult.getItemList().get(2));
			}
			Collections.shuffle(finalList);

			//item = new SolrItem();
			//item.setJobId(3074);
//		item.setJobName("算法工程师");
//		item.setEducation(1);
//		item.setWorkcity("北京");
//		item.setWelfare("年终奖金");
//		item.setSpecification("岗位职责：1、利用机器学习技术，改进头条的推荐、广告系统，优化用户的阅读体验；2、分析基础数据，挖掘用户兴趣、文章价值，增强推荐、广告系统的预测能力；3、分析用户商业意图，挖掘流量潜在商业价值，提升流量变现；4、研究计算机视觉算法，给用户提供更多更酷炫的功能。任职要求：1、3年以上的推荐系统、rank相关工作经验；2、强悍的编码能力，精通spark优先，精通c、c++、python语言优先；3、扎实的数据结构和算法功底；4、熟悉常用的推荐算法，能熟练解决常见的分类和回归问题；5、熟练使用以下任何一个开源工具者优先：xgboost、tensorflow、keras、theano、caffe；6、具备优秀的逻辑思维能力，对解决挑战性问题充满热情，善于解决问题和分析问题；7、具备良好的团队合作精神，较强的沟通能力和学习能力。工作地址：福建省福州市国家863专业软件孵化器510查看职位地图");
			return Layui.data((long)finalList.size(), finalList);
			//return TaotaoResult.ok(searchResult);
		}
	}
}

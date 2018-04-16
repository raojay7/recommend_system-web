package com.recommend_system.search.tempdao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.recommend_system.search.tempdao.ItemDao;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MoreLikeThisParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taotao.common.pojo.SearchResult;
import com.taotao.common.pojo.SolrItem;

/**
 * 搜索索引库
 * <p>Title: ItemDaoImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年8月22日下午3:08:34
 * @version 1.0
 */
@Repository
public class ItemDaoImpl implements ItemDao
{
	
	@Autowired
	private SolrServer solrServer;

	@Override
	public SearchResult searchItem(SolrQuery solrQuery) throws Exception {
		
		//根据查询条件查询索引库
		QueryResponse response = solrServer.query(solrQuery, SolrRequest.METHOD.POST);
		//从response中取查询结果
		SolrDocumentList list = response.getResults();
		//查询结果list
		List<SolrItem> itemList = new ArrayList<>();
		//遍历查询结果
		for (SolrDocument solrDocument : list) {
			//创建一商品对象
			SolrItem item = new SolrItem();
			item.setJobId(Integer.parseInt((String)solrDocument.get("id")));
			//取高亮显示
			Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
			List<String> hList = highlighting.get(solrDocument.get("id")).get("job_name");
			String job_name = "";
			//判断是否有高亮信息
			if (hList != null && hList.size() > 0) {
				job_name = hList.get(0);
			} else {
				job_name = (String) solrDocument.get("job_name");
			}
			item.setJobName(job_name);
			item.setSalaryMin((Integer) solrDocument.get("salary_min"));
			item.setSalaryMax((Integer) solrDocument.get("salary_max"));
			item.setEducation((Integer) solrDocument.get("education"));
			item.setWorkplace((String) solrDocument.get("workplace"));
			item.setWorkexperienceMin((Integer) solrDocument.get("workexperience_min"));
			item.setWorkexperienceMax((Integer) solrDocument.get("workexperience_max"));
			item.setNeedNum((Integer) solrDocument.get("need_num"));
			item.setJobNature((Integer) solrDocument.get("job_nature"));
			item.setWelfare((String) solrDocument.get("welfare"));
			item.setWorkcity((String) solrDocument.get("workcity"));
			item.setCtime((Date) solrDocument.get("ctime"));
			item.setCompanyId((Integer) solrDocument.get("company_id"));
			item.setCompanyName((String) solrDocument.get("company_name"));
			//添加到工作列表
			itemList.add(item);
		}

		//创建SearchResult
		SearchResult result = new SearchResult();
		result.setItemList(itemList);
		//查询返回结果的总数量
		result.setTotal(list.getNumFound());
		//返回结果
		return result;
	}

	@Override
	public SearchResult moreIikeByItem(SolrItem item) throws Exception {
		SolrQuery query = new SolrQuery();
		query.setRequestHandler("/mlt");

//        query.addFilterQuery("job_name:"+item.getJobName());
//        query.addFilterQuery("education:"+item.getEducation());
//        query.addFilterQuery("workcity:"+item.getWorkcity());
//        query.addFilterQuery("welfare:"+item.getWelfare());

//        query.setQuery("job_name:"+item.getJobName()+
//        " AND "+"welfare:"+item.getWelfare());
//        // query.setQuery("specification"+item.getSpecification());
//        query.setFilterQueries("job_name:"+item.getJobName()+
//        " AND "+"education:"+item.getEducation()+
//        " AND "+"workcity:"+item.getWorkcity());

		//如果setQuery中的查询条件，不是唯一结果，是多个文章，那么程序中会得到每个文章对应的moreLikeThis列表。
		//查询与某个id相似的结果
		query.setQuery("id:"+item.getJobId());

		//mlt在查询时，打开/关闭 MoreLikeThisComponent 的布尔值
		query.set(MoreLikeThisParams.MLT, "true");
		//fl 需要返回的字段
		query.setParam("fl", "id,job_name,salary_min,salary_max,education,workplace," +
				"workexperience_min,workexperience_max,job_nature,need_num,welfare,company_name,workcity," +
				"ctime,company_id");
		//mtl.fl 根据哪些字段判断相似度
		query.setParam("mlt.fl", "job_name,education,specification,workcity,welfare");
		//query.setParam("mlt.fl", "job_name,specification");

		// 如果一个词在所有文本中出现次数小于1，则不考虑
		query.set(MoreLikeThisParams.MIN_DOC_FREQ, 1);
		// 如果一个词在原始文本中出现次数小于1，则不考虑
		query.set(MoreLikeThisParams.MIN_TERM_FREQ, 1);
		// 长度低于此参数的词语不考虑，对中文来讲,单字无意义
		query.set(MoreLikeThisParams.MIN_WORD_LEN, 2);
		// 返回的与一段文本最相关的关键词个数。太大会导致查询性能下降
		query.set(MoreLikeThisParams.MAX_QUERY_TERMS, 10);
		// 查询结果不包含原始文档
		query.set(MoreLikeThisParams.MATCH_INCLUDE, false);
		//设置加权
		query.set(MoreLikeThisParams.BOOST, true);
		//设置这个值起作用
		query.set(MoreLikeThisParams.QF, "job_name^3.0 specification^4.0 company_name^1.7 ");

		QueryResponse resp = solrServer.query(query);
		SolrDocumentList sdl = resp.getResults();

		for (SolrDocument sd : sdl)
		{
			System.out.println("------");
			System.out.println(sd.getFieldValue("job_name"));
			System.out.println(sd.getFieldValue("company_name"));
			System.out.println(sd.getFieldValue("workcity"));
			System.out.println(sd.getFieldValue("salary_min"));
			System.out.println(sd.getFieldValue("workexperience_max"));
			System.out.println(sd.getFieldValue("welfare"));
			System.out.println(sd.getFieldValue("ctime"));
			// System.out.println(sd.getFieldValue("specification"));


			System.out.println("------");
		}
		System.out.println("---------------");
		//查询结果list
		List<SolrItem> itemList = new ArrayList<>();
		int total = 0;
		for (SolrDocument solrDocument : sdl)
		{
			SolrItem solrItem = new SolrItem();
			solrItem.setJobId(Integer.parseInt((String)solrDocument.get("id")));
			solrItem.setJobName((String)solrDocument.get("job_name"));
			solrItem.setSalaryMin((Integer)solrDocument.get("salary_min"));
			solrItem.setSalaryMax((Integer)solrDocument.get("salary_max"));
			solrItem.setEducation((Integer)solrDocument.get("education"));
			solrItem.setWorkplace((String)solrDocument.get("workplace"));
			solrItem.setWorkexperienceMin((Integer)solrDocument.get("workexperience_min"));
			solrItem.setWorkexperienceMax((Integer)solrDocument.get("workexperience_max"));
			solrItem.setNeedNum((Integer)solrDocument.get("need_num"));
			solrItem.setJobNature((Integer)solrDocument.get("job_nature"));
			solrItem.setWelfare((String)solrDocument.get("welfare"));
			solrItem.setWorkcity((String)solrDocument.get("workcity"));
			solrItem.setCtime((Date)solrDocument.get("ctime"));
			solrItem.setCompanyId((Integer)solrDocument.get("company_id"));
			solrItem.setCompanyName((String)solrDocument.get("company_name"));
			//添加到工作列表
			itemList.add(solrItem);
			total++;
		}
		System.out.println("一共有" + sdl.getNumFound() + "相似数据");
		System.out.println("最大分"+sdl.getMaxScore());
		//创建SearchResult
		SearchResult result = new SearchResult();
		result.setItemList(itemList);
		//查询返回结果的总数量
		result.setTotal(total);
		return result;
	}

	private String transEdu(Integer education) {
		switch (education){
			case 0:
				return "大专及以下";
			case 1:
				return "本科";
			case 2:
				return "硕士";
			case 3:
				return "博士";
				default:
					return "不限";
		}
	}

}

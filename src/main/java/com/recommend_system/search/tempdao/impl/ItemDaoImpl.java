package com.recommend_system.search.tempdao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.recommend_system.search.tempdao.ItemDao;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
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
		QueryResponse response = solrServer.query(solrQuery);
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

}

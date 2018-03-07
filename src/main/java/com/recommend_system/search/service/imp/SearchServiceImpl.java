package com.recommend_system.search.service.imp;

import com.recommend_system.search.service.SearchService;
import com.recommend_system.search.tempdao.ItemDao;
import com.taotao.common.pojo.SearchResult;
import com.taotao.common.pojo.SolrItem;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService
{
	@Override
	public SearchResult moreIikeByItem(SolrItem item) throws Exception {
		SearchResult searchResult = itemDao.moreIikeByItem(item);
		searchResult.setPageCount(1);
		searchResult.setPage(1);
		return searchResult;
	}

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public SearchResult search(String queryString, Long page, Long pageSize, boolean highLight) throws Exception {
		//创建查询对象
		SolrQuery solrQuery = new SolrQuery();
		//设置查询条件
		//solrQuery.set("q","");
		solrQuery.setQuery(queryString);
		//设置分页
		solrQuery.setStart((int) ((page - 1) * pageSize));
		solrQuery.setRows(pageSize.intValue());
		//高亮设置
		solrQuery.setHighlight(true);
		//设置高亮显示的域
		solrQuery.addHighlightField("job_name");
		if(highLight) {
			//高亮显示的前缀
			solrQuery.setHighlightSimplePre("<span style='color:red'>");
			//高亮显示的后缀
			solrQuery.setHighlightSimplePost("</span>");
		}
		//设置默认搜素域
		solrQuery.set("df", "item_keywords");
		//调用dao查询商品列表
		SearchResult searchResult = itemDao.searchItem(solrQuery);
		//计算总页数
		long total = searchResult.getTotal();
		long pageCount = total / pageSize;
		if (total % pageSize > 0) {
			pageCount++;
		}
		searchResult.setPageCount(pageCount);
		searchResult.setPage(page);
		//返回结果
		return searchResult;
	}

}

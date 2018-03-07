package com.recommend_system.search.tempdao;

import com.taotao.common.pojo.SolrItem;
import org.apache.solr.client.solrj.SolrQuery;

import com.taotao.common.pojo.SearchResult;

public interface ItemDao {

	SearchResult searchItem(SolrQuery solrQuery) throws Exception;

	SearchResult moreIikeByItem(SolrItem item)throws Exception;
}

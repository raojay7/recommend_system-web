package com.recommend_system.search.service;

import com.taotao.common.pojo.SearchResult;
import com.taotao.common.pojo.SolrItem;

public interface SearchService {

	SearchResult search(String queryString, Long page, Long pageSize, boolean highLight) throws Exception;

	SearchResult moreIikeByItem(SolrItem item)throws Exception;

}

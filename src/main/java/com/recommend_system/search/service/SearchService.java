package com.recommend_system.search.service;

import com.taotao.common.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, Long page, Long pageSize) throws Exception;
}

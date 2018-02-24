package com.recommend_system.search.dao;

import java.util.List;

import com.taotao.common.pojo.SolrItem;

public interface ItemMapper {
	List<SolrItem> getItemList();
}

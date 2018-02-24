package com.recommend_system.search.controller;

import com.recommend_system.search.service.SearchService;
import com.taotao.common.pojo.Layui;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.SearchResult;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping("/q")
	@ResponseBody
	public Layui search(@RequestParam("kw")String queryString, @RequestParam(defaultValue="1")Long page, @RequestParam(defaultValue="30")Long limit)
	{
		System.out.println("进入了search方法");
		if (StringUtils.isBlank(queryString))
		{
			//return TaotaoResult.build(400, "查询条件不能为空");
			return Layui.data((long)0, null);
		}
		try
		{
			//解决get乱码问题
			queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			SearchResult searchResult = searchService.search(queryString, page, limit);
			return Layui.data(searchResult.getTotal(), searchResult.getItemList());
			//return TaotaoResult.ok(searchResult);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
			return Layui.data((long)0, null);
		}

	}
}

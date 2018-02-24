package com.recommend_system.search.service.imp;

import com.recommend_system.search.dao.ItemMapper;
import com.recommend_system.search.service.ItemService;
import com.taotao.common.pojo.SolrItem;
import com.taotao.common.pojo.TaotaoResult;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 向索引库中导入商品信息
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年8月22日上午11:42:32
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService
{

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public TaotaoResult importAllItems() throws Exception {
		//查询商品列表
		List<SolrItem> list = itemMapper.getItemList();
		//向索引库中添加文档
		for (SolrItem solrItem : list) {
			//创建文档对象
			SolrInputDocument document = new SolrInputDocument();
			document.setField("id", solrItem.getJobId());
			document.setField("job_name", solrItem.getJobName());
			document.setField("salary_min", solrItem.getSalaryMin());
			document.setField("salary_max", solrItem.getSalaryMax());
			document.setField("education", solrItem.getEducation());
			document.setField("workplace", solrItem.getWorkplace());
			document.setField("workexperience_min", solrItem.getWorkexperienceMin());
			document.setField("workexperience_max", solrItem.getWorkexperienceMax());
			document.setField("need_num", solrItem.getNeedNum());
			document.setField("ctime", solrItem.getCtime());
			document.setField("job_nature", solrItem.getJobNature());
			document.setField("specification", solrItem.getSpecification());
			document.setField("welfare", solrItem.getWelfare());
			document.setField("workcity", solrItem.getWorkcity());
			document.setField("company_id", solrItem.getCompanyId());
			document.setField("company_name", solrItem.getCompanyName());


			//向索引库中添加文档
			solrServer.add(document);
		}
		//提交修改
		solrServer.commit();
		System.out.println("service导入成功");

		return TaotaoResult.ok();
	}

}

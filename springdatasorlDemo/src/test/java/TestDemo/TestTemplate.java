package TestDemo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.demo.TbItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-solr.xml")
public class TestTemplate {
	
	@Autowired
	private SolrTemplate solrTemplate;

	@Test
	public void addTest() {
		TbItem item = new TbItem();
		item.setId(1l);
		item.setTitle("华为navo2plus");
		item.setBrand("华为");
		item.setCategory("手机");
		item.setGoodsId(1l);
		item.setPrice(new BigDecimal(3000.02));
		item.setSeller("华为旗舰店");
		
		solrTemplate.saveBean(item);
		solrTemplate.commit();
	}
	
	@Test
	public void findById() {
		
		TbItem item = solrTemplate.getById(1l, TbItem.class);
		System.out.println(item.getTitle());
	}
	
	@Test
	public void deleteById() {
		solrTemplate.deleteById("1");
		solrTemplate.commit();
	}
	
	
	//批量插入数据
	@Test
	public void addTestList() {
		List list = new  ArrayList<Object>();
		
		for(int i=0;i<100;i++) {
			TbItem item = new TbItem();
			item.setId(i+1l);
			item.setTitle("华为navo"+i+"plus");
			item.setBrand("华为");
			item.setCategory("手机");
			item.setGoodsId(1l);
			item.setPrice(new BigDecimal(3000.02+i));
			item.setSeller("华为旗舰店");
			list.add(item);
		}
		solrTemplate.saveBeans(list);
		solrTemplate.commit();
	}
	
//	分页
	@Test
	public void pageTest() {
		
		Query query = new SimpleQuery("*:*");
		query.setOffset(0);//起始分页数
		query.setRows(10);//最多显示多少行
		
		ScoredPage<TbItem> page = solrTemplate.queryForPage(query , TbItem.class);
//		遍历
		for (TbItem tbItem : page) {
			System.out.println(tbItem.getTitle()+"\t"+tbItem.getPrice()+"\t"+tbItem.getBrand());
		}
		
		System.out.println("总记录数"+page.getTotalElements());
		System.out.println("总页数"+page.getTotalPages());
	}
	
	
	@Test
	public void pageTestMunit() {
		
		Query query = new SimpleQuery("*:*");
		
		Criteria criteria=new Criteria("item_category").contains("手机");
		criteria=criteria.and("item_title").contains("5");		
		query.addCriteria(criteria);

		
		
//		query.setOffset(0);//起始分页数
//		query.setRows(10);//最多显示多少行
		
		ScoredPage<TbItem> page = solrTemplate.queryForPage(query , TbItem.class);
//		遍历
		for (TbItem tbItem : page) {
			System.out.println(tbItem.getTitle()+"\t"+tbItem.getPrice()+"\t"+tbItem.getBrand());
		}
		
		System.out.println("总记录数"+page.getTotalElements());
		System.out.println("总页数"+page.getTotalPages());
	}
	
	
//	删除
	@Test
	public void deleteAll() {
		Query query = new SimpleQuery("*:*");//删除条件
		solrTemplate.delete(query);
		solrTemplate.commit();//提交
	}
	
	

}

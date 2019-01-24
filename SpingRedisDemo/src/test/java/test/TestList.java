package test;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis.xml")
public class TestList {
	
	@Autowired 
	private RedisTemplate redisTemplate;
	
	/**
	 * 左压栈
	 * 后添加的排后面
	 */
	@Test
	public void setList() {
		redisTemplate.boundListOps("namelist1").rightPush("刘备");
		redisTemplate.boundListOps("namelist1").rightPush("孙权");
		redisTemplate.boundListOps("namelist1").rightPush("张飞");
	}
	
	/**
	 * 获取
	 */
	@Test
	public void getList() {
		
		List list = redisTemplate.boundListOps("namelist1").range(0, 10);
		System.out.println(list);
	}
	
	
	/**
	 * 右压栈
	 */
	@Test
	public void setListLeft() {
		redisTemplate.boundListOps("namelist2").leftPush("曹操");
		redisTemplate.boundListOps("namelist2").leftPush("关羽");
		redisTemplate.boundListOps("namelist2").leftPush("大成");
	}
	
	@Test
	public void getListLeft() {
		List  list = redisTemplate.boundListOps("nameList2").range(0, 10);
		System.out.println(list);
	}
	
	/**
	 * 移除某个元素
	 */
	@Test
	public void removeList() {
		
		redisTemplate.boundListOps("nameList2").rename("张三");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		redisTemplate.delete("nameList2");
	}
}

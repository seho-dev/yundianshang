package test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis.xml")
public class TestValue {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
//	设置值
	@Test
	public void setValue() {
		
		redisTemplate.boundValueOps("name").set("itcast");
	}
	
	
//	获取
	@Test
	public void getValue() {
		String string = (String) redisTemplate.boundValueOps("name").get();
		System.out.println(string);
	}
	
//	删除
	@Test
	public void delete() {
//		使用key来删除value
		redisTemplate.delete("name");
	}
	
//	存储集合
	@Test
	public void setListValue() {
		redisTemplate.boundSetOps("setname").add("孙权");
		redisTemplate.boundSetOps("setname").add("曹操");
		redisTemplate.boundSetOps("setname").add("刘备");
	}
	
//	获取存储
	@Test
	public void getListValue() {
		
		Set set = redisTemplate.boundSetOps("setname").members();
		System.out.println(set);
	}
	
//	删除
	@Test
	public void deleteList() {
		redisTemplate.boundSetOps("setname");
	}
	
//	删除个别
	@Test
	public void removeList() {
		redisTemplate.boundSetOps("setname").remove("孙权");
	}
	
	
	
	
	
}

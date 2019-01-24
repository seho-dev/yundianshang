package test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis.xml")
public class TestHash {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	public void setHash() {
		/**
		 * 存入大key 大key中包含小key
		 */
		redisTemplate.boundHashOps("name").put("a", "唐僧");
		redisTemplate.boundHashOps("name").put("b", "孙悟空");
		redisTemplate.boundHashOps("name").put("c", "八戒");
		redisTemplate.boundHashOps("name").put("d", "沙参");
	}
	
	//获取所有的key 
	public void getHash() {
		redisTemplate.boundHashOps("name").keys();
	}
	
	
//	获取所有的value
	public void getValue() {
		redisTemplate.boundHashOps("name").values();
	}
	
//	根据KEY获取值
	public void getKey() {
		redisTemplate.boundHashOps("name").get("a");
	}
	
//	根据key删除value
	public void delteKey() {
		redisTemplate.boundHashOps("name").delete("c");
	}
	

}

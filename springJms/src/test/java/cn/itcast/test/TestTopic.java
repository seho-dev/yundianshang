package cn.itcast.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.demo.TopicProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-jms-topic.xml")
public class TestTopic {
	@Autowired
	private TopicProducer topicProducer;
	
	@Test
	public void testProducer() {
		topicProducer.sendMessage("spring jms ¶©ÔÄ·¢²¼");
	}
	

}

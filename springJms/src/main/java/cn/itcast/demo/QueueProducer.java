package cn.itcast.demo;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class QueueProducer {
	/**
	 * 使用spring整合Jms就是把创建工厂、创建连接、开启等直接交给spring管理便于直接注入开发
	 * 
	 * 使用JmsTemplat模板 ，提供的方法调用
	 * 
	 * 使用匿名类的方式调用接口直接创建实现类
	 * 
	 */
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Destination queueTextDestination;
	
	public void sendMessage(final String text) {
		jmsTemplate.send(queueTextDestination, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(text);
			}
		});
		
		
	}
	
}

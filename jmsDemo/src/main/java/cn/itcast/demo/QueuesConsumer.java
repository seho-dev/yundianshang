package cn.itcast.demo;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQXAConnectionFactory;

public class QueuesConsumer {

	public static void main(String[] args) throws JMSException, IOException {
		//1、创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQXAConnectionFactory("tcp://192.168.25.132:61616");
		//2、创建连接
		Connection connection = connectionFactory.createConnection();
		//3、开启连接
		connection.start();
		//4、创建session  org1 是否开启事务 org2 提交方式：自动提交
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5、创建队列对象
		Queue queue = session.createQueue("test-queue");
		//6、创建消息消费者
		MessageConsumer consumer = session.createConsumer(queue);
		//7、创建监听
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message massage) {
				TextMessage textMessage = (TextMessage) massage;
				try {
					System.out.println("收到的消息:"+textMessage.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		//8、等待键盘输入
		System.in.read();
		//9、关闭资源
		consumer.close();
		session.close();
		connection.close();
		
		
	}

}

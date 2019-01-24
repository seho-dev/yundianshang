package cn.itcast.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQXAConnectionFactory;
/**
 * Topic属于广播室
 * @author 鲜磊
 *
 */
public class TopicProducer {
	public static void main(String[] args) throws Exception{
		//1、创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQXAConnectionFactory("tcp://192.168.25.132:61616");
		//2、创建连接
		Connection connection = connectionFactory.createConnection();
		//3、开启连接
		connection.start();
		//4、创建session  org1 是否开启事务 org2 提交方式：自动提交
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5、创建订阅/主题队列对象
//		Queue queue = session.createQueue("test-queue");
		Topic topic = session.createTopic("test-topic");
		//6、创建消息生产者
		MessageProducer producer = session.createProducer(topic);
		//7、创建消息
		TextMessage textMessage = session.createTextMessage("欢迎来到品优购世界");
		//8、发送
		producer.send(textMessage);
		//9、关闭资源
		producer.close();
		session.close();
		connection.close();
		
	}
}

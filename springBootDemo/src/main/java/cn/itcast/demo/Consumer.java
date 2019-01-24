package cn.itcast.demo;

import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@JmsListener(destination="itcast")
	public void readeMessage(String text) {
		System.out.println("接收到的消息："+text);
		
	}
	
	
	@JmsListener(destination="itcast_map")
	public void readeMapMessage(Map map) {
		System.out.println("收到消息："+map);
	}
	

}

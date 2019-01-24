package cn.itcast.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
//	内置activeMQ
	@RequestMapping("/send")
	public void send(String text) {
		
		jmsMessagingTemplate.convertAndSend("itcast",text);
	}
	
//	外部web消息队列
	@RequestMapping("/sendSms")
	public void sendMap() {
		Map map = new HashMap();
		map.put("mobile", "15281892705");
		map.put("template_code", "SMS_70065005");
		map.put("sign_name", "易云Shop");
		map.put("param", "{\"number\":\"123456\"}");
		
		jmsMessagingTemplate.convertAndSend("sms", map);	
		
 		
	}
	
	
	
}

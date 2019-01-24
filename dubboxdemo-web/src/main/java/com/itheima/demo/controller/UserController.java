package com.itheima.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

//	属性注入
	@Reference
	private UserService userService;
	
//	访问路径
	@RequestMapping("/showName")
	@ResponseBody
	public String showName() {
		
		return userService.getName();
	}
	
}

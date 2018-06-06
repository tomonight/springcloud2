package com.yhem.yunmirror.oracle.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yhem.yunmirror.oracle.service.bean.User;
import com.yhem.yunmirror.oracle.service.mapper.UserMapper;
import com.yhem.yunmirror.oracle.service.service.feignService.MysqlService;
import com.yhem.yunmirror.oracle.service.service.feignService.MysqlService;


@RestController
public class TestController {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
    RestTemplate restTemplate;
	
	@Autowired
	MysqlService mysqlService;
	
	@RequestMapping("hello")
	@ResponseBody
	public User getOracleUser(){
		return userMapper.selectByPrimaryKey(1);
	}
	
	@RequestMapping("rmhello")
	@ResponseBody
	public User getRomoteUser(){
		return restTemplate.getForObject("http://service-mysql-service/hello",User.class);
		
	}
	
	@RequestMapping("fhello")
	@ResponseBody
	public Object fhello(){
		return mysqlService.sayHiFromClientOne("1");
	}
	
	
	
	
}

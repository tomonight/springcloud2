package com.yhem.yunmirror.mysql.service.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yhem.yunmirror.mysql.service.bean.User;
import com.yhem.yunmirror.mysql.service.mapper.UserMapper;
import com.yhem.yunmirror.mysql.service.service.feign.FeignService;


@RestController
public class TestController {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	FeignService FfeignService;
	
	@RequestMapping("hello")
	@ResponseBody
	public User test(HttpServletRequest request){
		
		String id = request.getParameter("id");
		return userMapper.selectByPrimaryKey(Integer.valueOf(id));
	}
		
	@RequestMapping("hello1")
	@ResponseBody
	public User test1(HttpServletRequest request){
		
		String id = request.getParameter("id");
		return userMapper.selectByPrimaryKey(Integer.valueOf(id));
	}
	
	@RequestMapping("fhello")
	@ResponseBody
	public Object fhello(HttpServletRequest request){
		
		String id = request.getParameter("id");
		return FfeignService.sayHiFromClientOne(id);
	}
}

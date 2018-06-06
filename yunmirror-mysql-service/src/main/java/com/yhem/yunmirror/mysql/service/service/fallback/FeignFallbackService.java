package com.yhem.yunmirror.mysql.service.service.fallback;

import org.springframework.stereotype.Component;

import com.yhem.yunmirror.mysql.service.service.feign.FeignService;

@Component
public class FeignFallbackService implements FeignService{

	@Override
	public Object sayHiFromClientOne(String id) {
		return "error";
	}

	
	
}

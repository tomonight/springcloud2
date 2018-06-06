package com.yhem.yunmirror.mysql.service.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yhem.yunmirror.mysql.service.service.fallback.FeignFallbackService;

@FeignClient(value = "service-oracle-service",fallback = FeignFallbackService.class)
public interface FeignService {

	@RequestMapping(value = "/hello",method = RequestMethod.GET)
    Object sayHiFromClientOne(@RequestParam(value = "id") String id);
}

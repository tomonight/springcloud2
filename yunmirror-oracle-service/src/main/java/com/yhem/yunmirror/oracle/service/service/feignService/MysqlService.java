package com.yhem.yunmirror.oracle.service.service.feignService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service-mysql-service")
public interface MysqlService {

	@RequestMapping(value = "/hello",method = RequestMethod.GET)
    Object sayHiFromClientOne(@RequestParam(value = "id") String id);
}

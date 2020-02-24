package com.wenqy.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 引用服务
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@FeignClient(name = "service-provider")
public interface EchoService {
	
    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);
}
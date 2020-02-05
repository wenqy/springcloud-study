package com.wenqy.consumer.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.consumer.hystrix.service.IFeignHystrixDemoService;

/**
 * feign hystrix
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@RestController
public class FeignHystrixDemoController {
	
	@Autowired
	IFeignHystrixDemoService feignDemoService;

	/**
	 * consume feign hystrix
	 * 	e.g: http://localhost:8010/consumeHystrix?name=hystrix
	 * @param name
	 * @return
	 * @author wenqy
	 * @date 2020年1月8日 下午7:44:19
	 */
    @GetMapping("/consumeHystrix")
    public String consumeHystrix(@RequestParam(value = "name", defaultValue = "wenqy") String name) {
    	return feignDemoService.consumerFeign(name);
    }
}

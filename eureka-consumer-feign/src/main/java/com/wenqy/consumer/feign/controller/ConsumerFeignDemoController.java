package com.wenqy.consumer.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.consumer.feign.service.IConsumerFeignDemoService;

/**
 * consumer feign
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@RestController
public class ConsumerFeignDemoController {

	@Autowired
	IConsumerFeignDemoService feignDemoService;
	
	/**
	 * consume feign
	 * @return
	 * @author wenqy
	 * @date 2020年1月8日 上午10:42:07
	 */
    @GetMapping("/consumeFeign")
    public String consumeFeign() {
    	return feignDemoService.consumerFeign();
    }
}

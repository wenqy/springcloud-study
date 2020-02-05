package com.wenqy.trace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TraceConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 启动zipkin-server\trace-provider\trace-consumer
	 * 测试请求 e.g http://localhost:8070/trace-1
	 * @return
	 * @author wenqy
	 * @date 2020年1月13日 下午2:22:02
	 */
	@RequestMapping("/trace-1")
    public String trace() {
    	logger.info("===call trace-1===");
    	return restTemplate.getForEntity("http://trace-provider/trace-2", String.class).getBody();
    }
}

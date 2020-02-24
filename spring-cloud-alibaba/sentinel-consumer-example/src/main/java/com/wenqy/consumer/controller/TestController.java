package com.wenqy.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wenqy.consumer.service.EchoSentinelService;
import com.wenqy.consumer.service.EchoService;

/**
 * 服务引用测试
 * 	先不开启Provider 会不会调用fallback
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@RestController
public class TestController {

	@Autowired
	private EchoService echoService;

	@Autowired
	private EchoSentinelService echoSentinelService;
	
	/**
	 * e.g. http://localhost:18084/echo-feign/wenqy
	 * @param str
	 * @return
	 * @author wenqy
	 * @date 2020年2月20日 下午12:22:52
	 */
	@GetMapping("/echo-feign/{str}")
	public String feign(@PathVariable String str) {
		return echoService.echo(str);
	}

	/**
	 * e.g. http://localhost:18084/echo-feign-sentinel/wenqy
	 * 		http://localhost:18184/echo-feign-sentinel/wenqy 两实例
	 * @param str
	 * @return
	 * @author wenqy
	 * @date 2020年2月20日 下午12:22:52
	 */
	@GetMapping("/echo-feign-sentinel/{str}")
	public String feignSentinel(@PathVariable String str) {
		return echoSentinelService.echo(str);
	}
	
	/**
	 * 自定义埋点
	 * 		blockHandler 是位于当前类下的 exceptionHandler 方法，需符合对应的类型限制. 限流使用
	 * 		fallback 降级使用
	 * @return
	 * @author wenqy
	 * @date 2020年2月20日 下午12:50:42
	 */
	@GetMapping("/hello/{str}")
	@SentinelResource(value = "resource", /*blockHandler = "exceptionHandler", */fallback = "fallbackHandler")
	public String hello(@PathVariable String str) {
		return "Hello " + str;
	}
	
	public String exceptionHandler(String str, BlockException ex) {
        ex.printStackTrace();
        return "Hello block handler " + str;
    }
	
	public String fallbackHandler(String str) {
        return "Hello fall back " + str;
    }
}
package com.wenqy.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * provider
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月7日
 */
@RestController
public class ProviderDemoController {

	@Value("${server.port}")
	String port;

	/**
	 * hi demo
	 * @param name
	 * @return
	 * @author wenqy
	 * @throws InterruptedException 
	 * @date 2020年1月7日 下午5:45:26
	 */
	@RequestMapping("/hi")
	public String hello(@RequestParam(value = "name", defaultValue = "wenqy") String name) throws InterruptedException {
		if ("hystrix".equalsIgnoreCase(name)) {
			Thread.sleep(6000L); // 如果为hystrix，休眠超时，用于hystrix测试
		}
		String result = "hi " + name + " , I am from port:" + port;
		System.out.println(result);
		return result;
	}
}

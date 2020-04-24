package com.wenqy.consumer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wenqy.consumer.service.EchoService;

/**
 * 服务消费者引用服务
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private EchoService echoService;

	/**
	 * restTemplate消费
	 * e.g. e.g. http://localhost:18083/echo-rest/wenqy
	 * @param str
	 * @return
	 * @author wenqy
	 * @date 2020年2月17日 上午11:00:47
	 */
	@GetMapping(value = "/echo-rest/{str}")
	public String rest(@PathVariable String str) {
		return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
	}

	/**
	 * feign消费
	 * 	e.g. http://localhost:18083/echo-feign/wenqy
	 * @param str
	 * @return
	 * @author wenqy
	 * @date 2020年2月17日 上午11:01:05
	 */
	@GetMapping(value = "/echo-feign/{str}")
	public String feign(@PathVariable String str) {
		return echoService.echo(str);
	}
	
	/**
	 * 访问登录页：http://localhost:18083/index
	 * vue 测试，提供后台服务登录接口
	 * @param name
	 * @param pwd
	 * @return
	 * @author wenqy
	 * @date 2020年3月16日 下午3:33:15
	 */
	@PostMapping(value = "/api/login")
	public Object login(String name, String pwd) {
		Map<Object, Object> hashMap = new HashMap<>();
		if ("admin".equals(name) && "123456".equals(pwd)) {
			hashMap.put("data", "success");
			hashMap.put("code", 200);
			return hashMap;
		}
		throw new RuntimeException("登录失败！");
	}
}
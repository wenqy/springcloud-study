package com.wenqy.dubbo.consumer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.dubbo.consumer.service.DubboFeignRestService;

@RestController
public class FeignRestController {

	@Autowired
	@Lazy
	private DubboFeignRestService dubboFeignRestService;

	/**
	 * e.g. http://localhost:48082/callPathVariables
	 * 
	 * @author wenqy
	 * @date 2020年3月16日 下午9:28:18
	 */
	@RequestMapping("callPathVariables")
	public Object callPathVariables() {
		// Spring Cloud Open Feign REST Call (Dubbo Transported)
		return dubboFeignRestService.pathVariables("c", "b", "a");
	}

	/**
	 * e.g. http://localhost:48082/callHeaders
	 * @return
	 * @author wenqy
	 * @date 2020年3月16日 下午9:30:35
	 */
	@RequestMapping("callHeaders")
	public Object callHeaders() {
		// Spring Cloud Open Feign REST Call (Dubbo Transported)
		return dubboFeignRestService.headers("b", 10, "a");
	}

	/**
	 * e.g. http://localhost:48082/callParam
	 * @return
	 * @author wenqy
	 * @date 2020年3月16日 下午9:31:18
	 */
	@RequestMapping("callParam")
	public Object callParam() {
		// Spring Cloud Open Feign REST Call (Dubbo Transported)
		return dubboFeignRestService.param("wenqy");
	}

	/**
	 * e.g. http://localhost:48082/callParams
	 * @return
	 * @author wenqy
	 * @date 2020年3月16日 下午9:31:21
	 */
	@RequestMapping("callParams")
	public Object callParams() {
		// Spring Cloud Open Feign REST Call (Dubbo Transported)
		return dubboFeignRestService.params("1", 1);
	}

	/**
	 * e.g. http://localhost:48082/callRequestBodyMap
	 * @return
	 * @author wenqy
	 * @date 2020年3月16日 下午9:32:08
	 */
	@RequestMapping("callRequestBodyMap")
	public Object callRequestBodyMap() {

		Map<String, Object> data = new HashMap<>();
		data.put("id", 1);
		data.put("name", "wenqy");
		data.put("age", 1);

		// Spring Cloud Open Feign REST Call (Dubbo Transported)
		return dubboFeignRestService.requestBody("Hello,World", data);
	}
}

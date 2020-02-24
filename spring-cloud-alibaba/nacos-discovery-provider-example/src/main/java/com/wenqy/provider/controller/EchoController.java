package com.wenqy.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
	
	/**
	 * 提供者提供服务
	 * 	e.g. http://localhost:18082/echo/wenqy
	 * @param string
	 * @return
	 * @author wenqy
	 * @date 2020年2月17日 上午10:19:24
	 */
	@GetMapping(value = "/echo/{string}")
	public String echo(@PathVariable String string) {
		return "Hello " + string;
	}
}
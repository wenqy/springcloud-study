package com.wenqy.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.slots.block.BlockException;

@RestController
public class EchoController {
	
	/**
	 * 提供者提供服务
	 * 	e.g. http://localhost:18087/echo/wenqy
	 * @param string
	 * @return
	 * @author wenqy
	 * @throws BlockException 
	 * @date 2020年2月17日 上午10:19:24
	 */
	@GetMapping(value = "/echo/{string}")
	public String echo(@PathVariable String string) {
		return "Hello " + string;
	}
}
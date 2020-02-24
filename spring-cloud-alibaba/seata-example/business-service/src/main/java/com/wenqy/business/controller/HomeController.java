package com.wenqy.business.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.business.service.HomeService;


@RestController
public class HomeController {

	@Autowired
	private HomeService homeService;

	/**
	 * e.g. http://localhost:38084/seata/rest
	 * @return
	 * @author wenqy
	 * @date 2020年2月21日 下午10:47:35
	 */
	@GetMapping(value = "/seata/rest", produces = "application/json")
	public String rest() {
		return homeService.purchaseByRest();
	}

	/**
	 * e.g. http://localhost:38084/seata/feign
	 * @return
	 * @author wenqy
	 * @date 2020年2月21日 下午10:48:03
	 */
	@GetMapping(value = "/seata/feign", produces = "application/json")
	public String feign() {
		return homeService.purchaseByFeign();
	}

}

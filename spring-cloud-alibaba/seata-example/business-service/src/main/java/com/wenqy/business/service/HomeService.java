package com.wenqy.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.wenqy.business.controller.HomeController;
import com.wenqy.business.interfaces.OrderService;
import com.wenqy.business.interfaces.StorageService;

import io.seata.spring.annotation.GlobalTransactional;

@Service
public class HomeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	private static final String SUCCESS = "SUCCESS";

	private static final String FAIL = "FAIL";

	private static final String USER_ID = "U100001";

	private static final String COMMODITY_CODE = "C00321";

	private static final int ORDER_COUNT = 2;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private OrderService orderService;

	@Autowired
	private StorageService storageService;
	
	/**
	 * rest风格
	 * @return
	 * @author wenqy
	 * @date 2020年2月21日 下午11:08:20
	 */
	@GlobalTransactional(timeoutMills = 300000, name = "spring-cloud-demo-tx")
	public String purchaseByRest() {
		String result = storage();

		if (!SUCCESS.equals(result)) {
			throw new RuntimeException("调用 storageService失败！！");
		}

		result = order();
		if (!SUCCESS.equals(result)) {
			throw new RuntimeException("调用 orderService失败！！");
		}

		return SUCCESS;
	}

	private String order() {
		String result;
		String url = "http://order-service/order";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", USER_ID);
		map.add("commodityCode", COMMODITY_CODE);
		map.add("orderCount", ORDER_COUNT + "");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(
				map, headers);

		ResponseEntity<String> response;
		try {
			response = restTemplate.postForEntity(url, request, String.class);
		}
		catch (Exception exx) {
			throw new RuntimeException("mock error " + exx.getMessage());
		}
		result = response.getBody();
		return result;
	}

	private String storage() {
		return restTemplate.getForObject(
				"http://storage-service/storage/" + COMMODITY_CODE + "/" + ORDER_COUNT,
				String.class);
	}
	
	/**
	 * Business -> storage (库存-2)
	 * 			-> order
	 * 				-> account (余额-2*2)
	 * 				新增订单
	 * 				
	 * @return
	 * @author wenqy
	 * @date 2020年2月21日 下午11:06:30
	 */
	@GlobalTransactional(timeoutMills = 300000, name = "spring-cloud-demo-tx")
	public String purchaseByFeign() {
		String result = storageService.storage(COMMODITY_CODE, ORDER_COUNT);

		if (!SUCCESS.equals(result)) {
			throw new RuntimeException("调用 storageService失败！！");
		}

		result = orderService.order(USER_ID, COMMODITY_CODE, ORDER_COUNT);

		if (!SUCCESS.equals(result)) {
			throw new RuntimeException("调用 orderService失败！！");
		}

		return SUCCESS;
	}
}

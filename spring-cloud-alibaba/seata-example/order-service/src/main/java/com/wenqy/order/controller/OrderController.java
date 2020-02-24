package com.wenqy.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.order.entity.Order;
import com.wenqy.order.service.OrderService;

import io.seata.core.context.RootContext;


@RestController
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	private static final String SUCCESS = "SUCCESS";

	private static final String FAIL = "FAIL";

//	private static final String COMMODITY_CODE = "C00321";

	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping(value = "/order", produces = "application/json")
	public String order(String userId, String commodityCode, int orderCount) {
		LOGGER.info("Order Service Begin ... xid: " + RootContext.getXID());
		Order order = createOrder(userId, commodityCode, orderCount);
		int result = orderService.order(order);
		LOGGER.info("Order Service End ... Created " + order);
		if (result == 1) {
			return SUCCESS;
		}
		return FAIL;
	}

	private Order createOrder(String userId, String commodityCode, int orderCount) {
		int orderMoney = calculate(commodityCode, orderCount);
		final Order order = new Order();
		order.setUserId(userId);
		order.setCommodityCode(commodityCode);
		order.setCount(orderCount);
		order.setMoney(orderMoney);
		return order;
	}

	private int calculate(String commodityId, int orderCount) {
		return 2 * orderCount;
	}

}

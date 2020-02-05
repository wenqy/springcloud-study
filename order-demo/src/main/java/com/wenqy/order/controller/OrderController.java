package com.wenqy.order.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.order.service.IOrderService;

import io.swagger.annotations.ApiOperation;

/**
 * 订单 Controller
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	/**
	 * 下单模拟操作
	 * 	e.g: http://localhost:8400/swagger-ui.html
	 * @param count 数量
	 * @param amount 金额
	 * @return
	 * @author wenqy
	 * @date 2020年1月9日 上午9:56:20
	 */
    @PostMapping(value = "/orderPay")
    @ApiOperation(value = "订单支付接口（创建订单并进行支付扣减库存模拟操作）")
    public String orderPay(@RequestParam(value = "count") Integer count,
                           @RequestParam(value = "amount") BigDecimal amount) {
        return orderService.orderPay(count, amount);

    }
}

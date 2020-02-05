package com.wenqy.order.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenqy.common.utils.IdWorkerUtils;
import com.wenqy.order.entity.Order;
import com.wenqy.order.enums.OrderStatusEnum;
import com.wenqy.order.mapper.OrderMapper;
import com.wenqy.order.service.IOrderService;
import com.wenqy.order.service.IPaymentService;

/**
 * order
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private IPaymentService paymentService;
	
	@Override
	public String orderPay(Integer count, BigDecimal amount) {
		final Order order = buildOrder(count, amount);
        final int rows = orderMapper.save(order);
        if (rows > 0) {
            paymentService.makePayment(order);
        }
        return "success";
	}

	private Order buildOrder(Integer count, BigDecimal amount) {
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setNumber(IdWorkerUtils.getInstance().buildPartNumber());
        //demo中的表里只有商品id为 1的数据
        order.setProductId("1");
        order.setStatus(OrderStatusEnum.NOT_PAY.getCode());
        order.setTotalAmount(amount);
        order.setCount(count);
        //demo中 表里面存的用户id为10000
        order.setUserId("10000");
        return order;
    }
}

package com.wenqy.order.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenqy.order.client.AccountClient;
import com.wenqy.order.client.InventoryClient;
import com.wenqy.order.dto.AccountDTO;
import com.wenqy.order.dto.InventoryDTO;
import com.wenqy.order.entity.Order;
import com.wenqy.order.enums.OrderStatusEnum;
import com.wenqy.order.mapper.OrderMapper;
import com.wenqy.order.service.IPaymentService;

@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
    private OrderMapper orderMapper;
	@Autowired
    private AccountClient accountClient;
	@Autowired
    private InventoryClient inventoryClient;
    
	@Override
	public void makePayment(Order order) {
		order.setStatus(OrderStatusEnum.PAY_SUCCESS.getCode());
        orderMapper.update(order); // 状态更新
        //检查数据
        final BigDecimal accountInfo = accountClient.findByUserId(order.getUserId());
        if (accountInfo.compareTo(order.getTotalAmount()) < 0) {
        	throw new RuntimeException("余额不足！");
        }

        final Integer inventoryInfo = inventoryClient.findByProductId(order.getProductId());
        if (inventoryInfo < order.getCount()) {
            throw new RuntimeException("库存不足！");
        }
        
        //进入扣减库存操作
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setCount(order.getCount());
        inventoryDTO.setProductId(order.getProductId());
        inventoryClient.decrease(inventoryDTO);
        //扣除用户余额
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAmount(order.getTotalAmount());
        accountDTO.setUserId(order.getUserId());
        accountClient.payment(accountDTO);
	}

}

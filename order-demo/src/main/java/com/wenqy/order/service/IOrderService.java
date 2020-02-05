package com.wenqy.order.service;

import java.math.BigDecimal;

/**
 * order service
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
public interface IOrderService {

	/**
	 * 下单，减余额，减库存操作
	 * @param count	购买数量
	 * @param amount 支付金额
	 * @return
	 * @author wenqy
	 * @date 2020年1月9日 上午9:59:13
	 */
    String orderPay(Integer count, BigDecimal amount);
}

package com.wenqy.order.service;

import com.wenqy.order.entity.Order;

/**
 * payment service
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
public interface IPaymentService {

    /**
     * 订单支付.
     *
     * @param order 订单实体
     */
    void makePayment(Order order);
}

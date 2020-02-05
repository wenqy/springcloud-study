package com.wenqy.order.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.wenqy.order.entity.Order;

/**
 * order mapper
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
public interface OrderMapper {

    /**
     * 保存订单
     * @param order
     * @return
     * @author wenqy
     * @date 2020年1月9日 上午10:07:24
     */
    @Insert(" insert into `order` (create_time,number,status,product_id,total_amount,count,user_id) "
            + " values ( #{createTime},#{number},#{status},#{productId},#{totalAmount},#{count},#{userId})")
    int save(Order order);

    /**
     * 更新订单.
     *
     * @param order 订单对象
     * @return rows
     */
    @Update("update `order` set status = #{status} , total_amount=#{totalAmount} where number=#{number}")
    int update(Order order);
}

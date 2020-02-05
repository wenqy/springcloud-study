package com.wenqy.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wenqy.order.dto.InventoryDTO;
import com.wenqy.order.fallback.InventoryFallback;

/**
 * 库存 服务
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
@FeignClient(value = "inventory-service",fallback = InventoryFallback.class)
public interface InventoryClient {

    /**
     * 库存扣减.
     *
     * @param inventoryDTO 实体对象
     * @return true 成功
     */
    @RequestMapping("/inventory/decrease")
    Boolean decrease(@RequestBody InventoryDTO inventoryDTO);

    /**
     * 获取商品库存.
     *
     * @param productId 商品id
     * @return InventoryDO integer
     */
    @RequestMapping("/inventory/findByProductId")
    Integer findByProductId(@RequestParam("productId") String productId);

}
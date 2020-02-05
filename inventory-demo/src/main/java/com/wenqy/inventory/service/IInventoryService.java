package com.wenqy.inventory.service;

import com.wenqy.inventory.dto.InventoryDTO;
import com.wenqy.inventory.entity.InventoryDO;

/**
 * 库存接口服务
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
public interface IInventoryService {


    /**
     * 扣减库存操作.
     * 这一个tcc接口
     *
     * @param inventoryDTO 库存DTO对象
     * @return true
     */
    Boolean decrease(InventoryDTO inventoryDTO);

    /**
     * 获取商品库存信息.
     * @param productId 商品id
     * @return InventoryDO
     */
    InventoryDO findByProductId(String productId);
}

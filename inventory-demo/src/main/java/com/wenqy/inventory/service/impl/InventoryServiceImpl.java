package com.wenqy.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenqy.inventory.dto.InventoryDTO;
import com.wenqy.inventory.entity.InventoryDO;
import com.wenqy.inventory.mapper.InventoryMapper;
import com.wenqy.inventory.service.IInventoryService;

/**
 * 库存服务 实现类
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
@Service("inventoryService")
public class InventoryServiceImpl implements IInventoryService {

	@Autowired
	private InventoryMapper inventoryMapper;
	
	@Override
	public Boolean decrease(InventoryDTO inventoryDTO) {
		inventoryMapper.decrease(inventoryDTO);
        return true;
	}

	@Override
	public InventoryDO findByProductId(String productId) {
		return inventoryMapper.findByProductId(productId);
	}

}

package com.wenqy.order.fallback;

import org.springframework.stereotype.Component;

import com.wenqy.order.client.InventoryClient;
import com.wenqy.order.dto.InventoryDTO;

@Component
public class InventoryFallback implements InventoryClient {

	@Override
	public Boolean decrease(InventoryDTO inventoryDTO) {
		System.out.println("com.wenqy.order.client.InventoryFallback.decrease fallback");
		return false;
	}

	@Override
	public Integer findByProductId(String productId) {
		System.out.println("com.wenqy.order.client.InventoryFallback.findByProductId fallback");
		return 0;
	}

}

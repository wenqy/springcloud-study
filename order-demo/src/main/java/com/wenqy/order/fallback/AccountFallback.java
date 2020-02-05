package com.wenqy.order.fallback;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.wenqy.order.client.AccountClient;
import com.wenqy.order.dto.AccountDTO;

@Component
public class AccountFallback implements AccountClient {

	@Override
	public Boolean payment(AccountDTO accountDO) {
		System.out.println("com.wenqy.order.fallback.AccountFallback.payment fallback");
		return false;
	}

	@Override
	public BigDecimal findByUserId(String userId) {
		System.out.println("com.wenqy.order.fallback.AccountFallback.findByUserId fallback");
		return null;
	}

}

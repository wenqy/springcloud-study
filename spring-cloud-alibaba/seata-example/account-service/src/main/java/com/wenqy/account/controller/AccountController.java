package com.wenqy.account.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.account.service.AccountService;

import io.seata.core.context.RootContext;


@RestController
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	private static final String SUCCESS = "SUCCESS";

	private static final String FAIL = "FAIL";

	private AccountService accountService;

	private Random random;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
		this.random = new Random();
	}

	/**
	 * 更新account
	 * @param userId
	 * @param money
	 * @return
	 * @author wenqy
	 * @date 2020年2月19日 上午10:55:51
	 */
	@PostMapping(value = "/account", produces = "application/json")
	public String account(String userId, int money) {
		LOGGER.info("Account Service ... xid: " + RootContext.getXID());

		if (random.nextBoolean()) { // 随机模拟异常
			throw new RuntimeException("Account 模拟异常抛错！！");
		}

		int result = accountService.updateAccountMoney(userId, money);
		LOGGER.info("Account Service End ... ");
		if (result == 1) {
			return SUCCESS;
		}
		return FAIL;
	}

}

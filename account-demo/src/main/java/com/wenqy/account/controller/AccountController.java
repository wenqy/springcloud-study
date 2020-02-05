package com.wenqy.account.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.account.dto.AccountDTO;
import com.wenqy.account.entity.AccountDO;
import com.wenqy.account.service.IAccountService;

/**
 * 
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
	@RequestMapping("/payment")
    public Boolean save(@RequestBody AccountDTO accountDO) {
        return accountService.payment(accountDO);
    }

    @RequestMapping("/findByUserId")
    public BigDecimal findByUserId(@RequestParam("userId") String userId) {
        AccountDO accountDO = accountService.findByUserId(userId);
        if (accountDO == null) {
        	return new BigDecimal(0L);
        }
		return accountDO.getBalance();
    }
}

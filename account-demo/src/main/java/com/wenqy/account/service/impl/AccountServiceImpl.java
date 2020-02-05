package com.wenqy.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenqy.account.dto.AccountDTO;
import com.wenqy.account.entity.AccountDO;
import com.wenqy.account.mapper.AccountMapper;
import com.wenqy.account.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public boolean payment(AccountDTO accountDTO) {
		accountMapper.update(accountDTO);
		return false;
	}

	@Override
	public AccountDO findByUserId(String userId) {
		return accountMapper.findByUserId(userId);
	}

}

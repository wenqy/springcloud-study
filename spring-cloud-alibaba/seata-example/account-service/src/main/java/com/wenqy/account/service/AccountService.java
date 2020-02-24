package com.wenqy.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 更新Account money
	 * @param userId
	 * @param money
	 * @return
	 * @author wenqy
	 * @date 2020年2月19日 上午10:33:19
	 */
	@Transactional
	public int updateAccountMoney(String userId, int money) {
		int result = jdbcTemplate.update(
				"update account_tbl set money = money - ? where user_id = ?",
				new Object[] { money, userId });
		return result;
	}
}

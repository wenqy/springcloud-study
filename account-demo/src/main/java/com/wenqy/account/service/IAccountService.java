package com.wenqy.account.service;

import com.wenqy.account.dto.AccountDTO;
import com.wenqy.account.entity.AccountDO;

public interface IAccountService {

	/**
     * 扣款支付.
     *
     * @param accountDTO 参数dto
     * @return true
     */
    boolean payment(AccountDTO accountDTO);

    /**
     * 获取用户账户信息.
     *
     * @param userId 用户id
     * @return AccountDO
     */
    AccountDO findByUserId(String userId);
}

package com.wenqy.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @param commodityCode
	 * @param count
	 * @return
	 * @author wenqy
	 * @date 2020年2月21日 下午11:02:29
	 */
	@Transactional
	public int updateAccountStorage(String commodityCode, int count) {
		int result = jdbcTemplate.update(
				"update storage_tbl set count = count - ? where commodity_code = ?",
				new Object[] { count, commodityCode });
		return result;
	}
}

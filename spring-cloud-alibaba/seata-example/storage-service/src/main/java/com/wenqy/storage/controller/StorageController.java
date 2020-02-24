package com.wenqy.storage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.storage.service.StorageService;

import io.seata.core.context.RootContext;

@RestController
public class StorageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StorageController.class);

	private static final String SUCCESS = "SUCCESS";

	private static final String FAIL = "FAIL";

	private StorageService storageService;

	@Autowired
	public StorageController(StorageService storageService) {
		this.storageService = storageService;
	}

	/**
	 * 更新storage
	 * @param commodityCode
	 * @param count
	 * @return
	 * @author wenqy
	 * @date 2020年2月19日 上午10:55:10
	 */
	@GetMapping(value = "/storage/{commodityCode}/{count}", produces = "application/json")
	public String storage(@PathVariable String commodityCode, @PathVariable int count) {
		LOGGER.info("Storage Service Begin ... xid: " + RootContext.getXID());
		int result = storageService.updateAccountStorage(commodityCode, count);
		LOGGER.info("Storage Service End ... ");
		if (result == 1) {
			return SUCCESS;
		}
		return FAIL;
	}

}

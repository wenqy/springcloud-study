package com.wenqy.dubbo.provider.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.wenqy.dubbo.api.EchoService;

@Service
public class EchoServiceImpl implements EchoService {

	@Override
	public String echo(String message) {
		return "[echo] Hello, I'm from provider: " + message;
	}

}

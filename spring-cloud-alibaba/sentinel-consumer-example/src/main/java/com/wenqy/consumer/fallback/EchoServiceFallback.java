package com.wenqy.consumer.fallback;

import com.wenqy.consumer.service.EchoService;

/**
 * 服务降级回调类
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
public class EchoServiceFallback implements EchoService {

	private Throwable throwable;

	EchoServiceFallback(Throwable throwable) {
		this.throwable = throwable;
	}

	@Override
	public String echo(String str) {
		return "hello fallback " + throwable.getMessage();
	}

}
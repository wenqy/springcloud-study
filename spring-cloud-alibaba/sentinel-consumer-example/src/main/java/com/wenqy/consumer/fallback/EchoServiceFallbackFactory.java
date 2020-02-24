package com.wenqy.consumer.fallback;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class EchoServiceFallbackFactory implements FallbackFactory<EchoServiceFallback> {

	@Override
	public EchoServiceFallback create(Throwable throwable) {
		return new EchoServiceFallback(throwable);
	}

}
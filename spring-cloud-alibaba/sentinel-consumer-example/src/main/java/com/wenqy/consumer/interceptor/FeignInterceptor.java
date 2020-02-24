package com.wenqy.consumer.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign声明式拦截
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月21日
 */
@Component
public class FeignInterceptor implements RequestInterceptor{

	@Value("${spring.application.name}")
	private String appName;
	
    public void apply(RequestTemplate requestTemplate) {
    	// 传递应用名
        requestTemplate.header("CUSTOM_APPNAME", appName);
    }
}
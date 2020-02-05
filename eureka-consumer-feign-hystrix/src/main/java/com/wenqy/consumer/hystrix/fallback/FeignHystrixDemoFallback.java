package com.wenqy.consumer.hystrix.fallback;

import org.springframework.stereotype.Component;

import com.wenqy.consumer.hystrix.service.IFeignHystrixDemoService;

/**
 * 降级逻辑处理类
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@Component
public class FeignHystrixDemoFallback implements IFeignHystrixDemoService {

	@Override
	public String consumerFeign(String name) {
		//  配置超时时间要小于服务休眠时间，并开启feign hystrix支持
		return name + " fallback";
	}

}

package com.wenqy.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * feign 定义服务提供者接口列表
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@FeignClient("provider-demo") // 也可定义在接口实现类
public interface IConsumerFeignDemoService {

	@RequestMapping("/hi") // 服务提供者暴露的请求
    String consumerFeign();
}

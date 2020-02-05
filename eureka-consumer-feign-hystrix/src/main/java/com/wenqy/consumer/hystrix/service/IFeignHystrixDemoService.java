package com.wenqy.consumer.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wenqy.consumer.hystrix.fallback.FeignHystrixDemoFallback;

@FeignClient(name="provider-demo", fallback = FeignHystrixDemoFallback.class) // 也可定义在接口实现类
public interface IFeignHystrixDemoService {

	@RequestMapping("/hi") // 服务提供者暴露的请求
    String consumerFeign(@RequestParam(value = "name", defaultValue = "wenqy") String name);
}

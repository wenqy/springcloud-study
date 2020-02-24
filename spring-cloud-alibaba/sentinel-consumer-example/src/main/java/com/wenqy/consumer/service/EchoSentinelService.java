package com.wenqy.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wenqy.consumer.fallback.EchoServiceFallbackFactory;

@FeignClient(name = "service-provider-sentinel", fallbackFactory = EchoServiceFallbackFactory.class)
public interface EchoSentinelService {

    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);
}

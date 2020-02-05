package com.wenqy.consumer.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * consume ribbon
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@RestController
public class ConsumerRibbonDemoController {

	@Autowired
    RestTemplate restTemplate;

    /**
     * consumeRibbon
     * @return
     * @author wenqy
     * @date 2020年1月8日 上午9:54:34
     */
    @GetMapping("/consumeRibbon")
    public String consumeRibbon() {
    	// 根据serverId负载到具体的服务实例
        return restTemplate.getForObject("http://provider-demo/hi", String.class);
    }
}

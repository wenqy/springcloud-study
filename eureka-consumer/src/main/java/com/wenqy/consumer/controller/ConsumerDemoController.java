package com.wenqy.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerDemoController {

	@Autowired
    LoadBalancerClient loadBalancerClient;
	
    @Autowired
    RestTemplate restTemplate;

    /**
     * consume
     * @return
     * @author wenqy
     * @date 2020年1月7日 下午9:26:09
     */
    @GetMapping("/consume")
    public String consume() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-demo");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hi";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}

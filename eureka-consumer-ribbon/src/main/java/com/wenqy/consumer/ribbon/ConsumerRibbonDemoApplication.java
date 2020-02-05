package com.wenqy.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * consumer-ribbon
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerRibbonDemoApplication {

	@LoadBalanced // Ribbon负载均衡
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerRibbonDemoApplication.class, args);
	}
}

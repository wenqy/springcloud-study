package com.wenqy.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Nacos Consumer Demo 启动类
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 开启feign注解扫描
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	
	 @Bean
	 @LoadBalanced
	 public RestTemplate restTemplate() {
	     return new RestTemplate();
	 }
}

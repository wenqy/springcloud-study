package com.wenqy.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;

@EnableAutoDataSourceProxy
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@LoadBalanced // Ribbon负载均衡
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

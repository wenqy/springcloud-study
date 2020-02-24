package com.wenqy.business;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;


/**
 * 下载Seata Server
 * 	https://github.com/seata/seata/releases
 * 启动 文件 单点模式
 * 	seata-server.cmd -p 8091 -m file
 * @version V5.0
 * @author wenqy
 * @date   2020年2月19日
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableAutoDataSourceProxy
public class BusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}

	@LoadBalanced // Ribbon负载均衡
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
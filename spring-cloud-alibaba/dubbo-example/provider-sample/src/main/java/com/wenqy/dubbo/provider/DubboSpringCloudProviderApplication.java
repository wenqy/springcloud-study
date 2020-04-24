package com.wenqy.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DubboSpringCloudProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboSpringCloudProviderApplication.class, args);
	}
}

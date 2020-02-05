package com.wenqy.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * provider
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月7日
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderDemoApplication.class, args);
	}

}

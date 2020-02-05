package com.wenqy.feign.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * feign uploadfile
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerFeignUploadApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignUploadApplication.class, args);
	}
}

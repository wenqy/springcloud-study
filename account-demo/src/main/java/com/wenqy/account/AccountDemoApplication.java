package com.wenqy.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Account 启动
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.wenqy.account.mapper")
public class AccountDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountDemoApplication.class, args);
	}
}

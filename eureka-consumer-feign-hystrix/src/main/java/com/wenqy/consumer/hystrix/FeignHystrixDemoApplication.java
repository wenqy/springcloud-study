package com.wenqy.consumer.hystrix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * feign hystrix
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@EnableFeignClients // 开启feign注解扫描
@SpringBootApplication
@EnableEurekaClient
public class FeignHystrixDemoApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(FeignHystrixDemoApplication.class).run(args);
	}
}

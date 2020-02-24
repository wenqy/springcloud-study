package com.wenqy.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Sentinel Demo 启动类
 * 下载sentinel-dashboard.jar
 * 启动
 * 	java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar
 * 访问
 * 	localhost:8080
 * 
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@EnableFeignClients
@SpringCloudApplication
public class SentinelConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentinelConsumerApplication.class, args);
	}
}

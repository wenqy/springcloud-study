package com.wenqy.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix 监控面板
 * 开启 eureka-consumer-ribbon-hystrix 单实例
 * 访问：http://localhost:8011/hystrix
 * 首页输入框：http://localhost:8009/actuator/hystrix.stream 单实例监控
 * 浏览器访问服务：http://localhost:8009/consumeHystrix?name=hystrix
 * 刷新监控界面
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@EnableHystrixDashboard // 开启hystrix dashboard
@SpringCloudApplication
public class HystrixDashboardApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
}

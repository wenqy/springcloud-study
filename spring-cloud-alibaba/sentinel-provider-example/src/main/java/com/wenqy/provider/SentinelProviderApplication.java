package com.wenqy.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Nacos Provider Demo 启动类
 * 	
 * 下载Nacos
 * 	https://github.com/alibaba/nacos/releases
 * 启动Nacos Server
 * 	windows: startup.cmd
 * 访问 localhost:8848/nacos/index.html  账号 nacos/nacos
 * 
 * 启动ProviderApplication nacos console 服务管理->服务列表
 * 	请求为：http://localhost:8848/nacos/v1/ns/catalog/services?hasIpCount=true&withInstances=false&pageNo=1&pageSize=10&serviceNameParam=&groupNameParam=&namespaceId=
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentinelProviderApplication.class, args);
	}

}
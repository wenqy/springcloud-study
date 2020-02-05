package com.wenqy.admin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * Admin UI 监控 启动类
 * 	e.g. http://localhost:9421/
 * 依赖：eureka-server
 * 客户端添加依赖：spring-boot-admin-client
 * @version V5.0
 * @author wenqy
 * @date   2020年1月18日
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer // 启用AdminServer
public class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }

}

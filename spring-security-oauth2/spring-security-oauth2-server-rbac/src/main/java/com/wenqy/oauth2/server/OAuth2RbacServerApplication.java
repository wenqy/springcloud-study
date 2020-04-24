package com.wenqy.oauth2.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于Rbac 自定义认证
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年3月27日
 */
@SpringBootApplication
@MapperScan("com.wenqy.oauth2.server.mapper")
public class OAuth2RbacServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2RbacServerApplication.class, args);
	}
}

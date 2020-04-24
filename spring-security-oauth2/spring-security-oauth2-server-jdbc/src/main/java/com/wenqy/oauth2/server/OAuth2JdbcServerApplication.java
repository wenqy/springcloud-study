package com.wenqy.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证服务器 基于JDBC令牌存储
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年3月27日
 */
@SpringBootApplication
public class OAuth2JdbcServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2JdbcServerApplication.class, args);
	}
}

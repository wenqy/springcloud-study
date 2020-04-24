package com.wenqy.security.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证服务器
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年3月27日
 */
@SpringBootApplication
public class OAuth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ServerApplication.class, args);
	}
}

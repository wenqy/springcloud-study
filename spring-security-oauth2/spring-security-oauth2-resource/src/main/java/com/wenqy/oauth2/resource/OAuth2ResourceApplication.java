package com.wenqy.oauth2.resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * 资源服务
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年3月27日
 */
@SpringBootApplication
@MapperScan("com.wenqy.oauth2.resource.mapper")
@EnableOAuth2Sso
public class OAuth2ResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ResourceApplication.class, args);
	}
}

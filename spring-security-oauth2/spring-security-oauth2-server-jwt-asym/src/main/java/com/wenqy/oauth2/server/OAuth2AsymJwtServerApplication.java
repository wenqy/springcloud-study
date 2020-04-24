package com.wenqy.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 生成证书
 * 	keytool -genkeypair -alias mytest -keyalg RSA -keypass mypass -keystore mytest.jks -storepass mypass
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年3月29日
 */
@SpringBootApplication
public class OAuth2AsymJwtServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2AsymJwtServerApplication.class, args);
	}
}

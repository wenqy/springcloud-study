package com.wenqy.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 导出公钥
 * 	keytool -list -rfc --keystore mytest.jks | openssl x509 -inform pem -pubkey -noout
 *  将输出结果保存至public.txt
 * @version V5.0
 * @author wenqy
 * @date   2020年3月29日
 */
@SpringBootApplication
public class OAuth2AsymJwtResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2AsymJwtResourceApplication.class, args);
	}
}

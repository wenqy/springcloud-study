package com.wenqy.dubbo.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DubboSpringCloudWebProviderApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DubboSpringCloudWebProviderApplication.class)
			.properties("spring.profiles.active=nacos").run(args);
	}
}

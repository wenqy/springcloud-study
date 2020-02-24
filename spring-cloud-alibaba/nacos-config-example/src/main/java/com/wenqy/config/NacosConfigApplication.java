package com.wenqy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wenqy.config.configbean.UserConfig;

/**
 * NacosConfig Demo 启动类
 * 	测试多环境，加属性 --spring.profiles.active=prod
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@SpringBootApplication
public class NacosConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosConfigApplication.class, args);
	}
	
	@Bean
	public UserConfig userConfig() {
		return new UserConfig();
	}
}

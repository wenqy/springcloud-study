package com.wenqy.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // Servlet注解扫描
@SpringBootApplication
public class ConfigClientDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientDemoApplication.class, args);
	}
}

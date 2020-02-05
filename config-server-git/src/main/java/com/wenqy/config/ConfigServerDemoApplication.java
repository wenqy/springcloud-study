package com.wenqy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * config center server
 * 	访问配置信息URL与配置文件的映射关系:
 * 		/{application}/{profile}[/{label}]
		/{application}-{profile}.yml
		/{label}/{application}-{profile}.yml
		/{application}-{profile}.properties
		/{label}/{application}-{profile}.properties

 *  e.g: http://localhost:8007/config-client/dev/master
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@ServletComponentScan // Servlet注解扫描
@EnableConfigServer // 开启配置服务端功能
@SpringBootApplication
public class ConfigServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerDemoApplication.class, args);
	}
}

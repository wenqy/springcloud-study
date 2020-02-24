package com.wenqy.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.config.configbean.UserConfig;

/**
 * Nacos console 修改配置
 * 	dataID
	在 Nacos Config Starter 中，dataId 的拼接格式如下
	
	${prefix} - ${spring.profiles.active} . ${file-extension}
	prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix来配置。
	
	spring.profiles.active 即为当前环境对应的 profile，详情可以参考 Spring Boot文档
	
	注意，当 activeprofile 为空时，对应的连接符 - 也将不存在，dataId 的拼接格式变成 ${prefix}.${file-extension}
	
	file-extension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension来配置。 默认 properties 类型。
	
	group
	group 默认为 DEFAULT_GROUP，可以通过 spring.cloud.nacos.config.group 配置。
	
	
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@RestController
@RefreshScope
public class SampleController {

	@Autowired
	UserConfig userConfig;

	@Value("${user.name}")
	String userName;

	@Value("${user.age:25}")
	Integer age;

	/**
	 * 配置中心修改
	 * 	访问是否实时生效，热加载配置
	 * 	e.g. 
	 * 		集群：
	 * 			localhost:18085/user
	 * 			localhost:18185/user   -Dserver.port=18185
	 * 		profile多环境
	 * 			localhost:18285/user   -Dserver.port=18285  --spring.profiles.active=prod
	 * @return
	 * @author wenqy
	 * @date 2020年2月20日 上午11:05:08
	 */
	@RequestMapping("/user")
	public String simple() {
		return "Hello Nacos Config!" + "Hello " + userName + " " + age + " [UserConfig]: "
				+ userConfig + "!";
	}

	@RequestMapping("/bool")
	public boolean bool() {
		return (Boolean) (userConfig.getMap().get("2"));
	}

}
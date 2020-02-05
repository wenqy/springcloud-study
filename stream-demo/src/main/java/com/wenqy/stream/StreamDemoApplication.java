package com.wenqy.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Stream 启动类
 * 		使用rabbitmq 先启动rabbitmq
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月10日
 */
@SpringBootApplication
public class StreamDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamDemoApplication.class, args);
	}
}

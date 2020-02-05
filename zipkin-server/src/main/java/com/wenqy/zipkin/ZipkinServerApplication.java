package com.wenqy.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

/**
 * zipkin 启动类
 * 	e.g localhost:9411
 * @version V5.0
 * @author wenqy
 * @date   2020年1月13日
 */
@EnableZipkinServer // 开启ZipkinServer
@SpringBootApplication
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}

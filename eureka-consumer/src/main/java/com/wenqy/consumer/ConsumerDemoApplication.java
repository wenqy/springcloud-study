package com.wenqy.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Consumer
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月7日
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerDemoApplication {

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	   
	public static void main(String[] args) {
		SpringApplication.run(ConsumerDemoApplication.class, args);
	}
}

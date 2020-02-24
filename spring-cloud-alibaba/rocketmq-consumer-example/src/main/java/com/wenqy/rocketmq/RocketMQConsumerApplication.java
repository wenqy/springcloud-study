package com.wenqy.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

import com.wenqy.rocketmq.binder.MySink;
import com.wenqy.rocketmq.runner.ConsumerCustomRunner;

/**
 * Rocketmq 消费 Demo 启动类
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@SpringBootApplication
@EnableBinding({Sink.class, MySink.class})
public class RocketMQConsumerApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(RocketMQConsumerApplication.class, args);
    }
    
    @Bean
	public ConsumerCustomRunner customRunner() {
		return new ConsumerCustomRunner();
	}
}
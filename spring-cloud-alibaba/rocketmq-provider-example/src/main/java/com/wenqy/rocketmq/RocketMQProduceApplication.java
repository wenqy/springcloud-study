package com.wenqy.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

import com.wenqy.rocketmq.binder.MySource;

/**
 * Rocketmq Demo 启动类
 * 	下载 RocketMq
 * 	启动	
 * 		Name Server启动
 * 			mqnamesrv.cmd
 * 		Broker启动
 * 			mqbroker.cmd -n localhost:9876
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@SpringBootApplication
@EnableBinding({Source.class, MySource.class})
public class RocketMQProduceApplication {

	public static void main(String[] args) {
        SpringApplication.run(RocketMQProduceApplication.class, args);
    }
}

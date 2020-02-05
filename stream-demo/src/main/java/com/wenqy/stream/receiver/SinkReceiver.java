package com.wenqy.stream.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 消息 消费者
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月10日
 */
@EnableBinding(Sink.class) // 绑定Channel
public class SinkReceiver {

	private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
	
	/**
	 * 注册事件监听器，处理Sink.INPUT通道的监听消息
	 * @param payload
	 * @author wenqy
	 * @date 2020年1月10日 上午11:25:57
	 */
	@StreamListener(Sink.INPUT)
	private void recevie(Object payload) {
		logger.info("Sink Received: " + payload);
	}
}

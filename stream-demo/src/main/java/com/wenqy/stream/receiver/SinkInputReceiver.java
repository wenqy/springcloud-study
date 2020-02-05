package com.wenqy.stream.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.wenqy.stream.binder.SinkInputSender;

@EnableBinding(SinkInputSender.class) // 绑定Channel
public class SinkInputReceiver {

private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
	
	/**
	 * 注册事件监听器，处理Sink.INPUT通道的监听消息
	 * @param payload
	 * @author wenqy
	 * @date 2020年1月10日 上午11:25:57
	 */
	@StreamListener(SinkInputSender.NAME)
	private void recevie(Object payload) {
		logger.info("SinkInput Received: " + payload);
	}
}

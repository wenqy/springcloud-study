package com.wenqy.rocketmq.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义 Binding
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
public interface MySink {

		@Input("input1")
		SubscribableChannel input1();

		@Input("input2")
		SubscribableChannel input2();

		@Input("input3")
		SubscribableChannel input3();

		@Input("input4")
		SubscribableChannel input4();

		@Input("input5")
		PollableMessageSource input5();

	}
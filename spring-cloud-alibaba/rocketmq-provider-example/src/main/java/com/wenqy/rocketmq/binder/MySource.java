package com.wenqy.rocketmq.binder;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义 Binding
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
public interface MySource {

	@Output("output1")
	MessageChannel output1();

	@Output("output2")
	MessageChannel output2();

	@Output("output3")
	MessageChannel output3();

}
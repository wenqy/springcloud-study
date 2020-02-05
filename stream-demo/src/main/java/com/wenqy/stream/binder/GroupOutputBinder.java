package com.wenqy.stream.binder;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface GroupOutputBinder {

	String NAME = "group-demo-topic";

	@Output(NAME)
	MessageChannel output();

}
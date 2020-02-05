package com.wenqy.stream.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SinkInputSender {

	public String NAME = "demo-topic"; // topic

    @Input(NAME)
    SubscribableChannel input();
}

package com.wenqy.stream.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface GroupInputBinder {

	public String NAME = "group-demo-topic"; // 分组 topic

    @Input(NAME)
    SubscribableChannel input();
}

package com.wenqy.rocketmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * 消息服务
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@Service
public class ProviderService {
	
    @Autowired
    private MessageChannel output;

    public void send(String message) {
        output.send(MessageBuilder.withPayload(message).build());
    }
}
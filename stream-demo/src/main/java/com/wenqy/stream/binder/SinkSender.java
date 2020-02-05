package com.wenqy.stream.binder;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 绑定发送
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月10日
 * @see org.springframework.cloud.stream.messaging.Source
 */
public interface SinkSender {

    String OUTPUT = "input";

    @Output(SinkSender.OUTPUT)
    MessageChannel output();

}
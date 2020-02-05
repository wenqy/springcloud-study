package com.wenqy.stream.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.wenqy.stream.binder.GroupInputBinder;

@EnableBinding(GroupInputBinder.class)
public class GroupDemoReceiver {

	private static Logger logger = LoggerFactory.getLogger(GroupInputBinder.class);

    @StreamListener(GroupInputBinder.NAME)
    public void receive(String payload) {
        logger.info("Group Received: " + payload);
    }
}

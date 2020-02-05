package com.wenqy.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.stream.binder.GroupOutputBinder;
import com.wenqy.stream.binder.SinkOutputSender;
import com.wenqy.stream.binder.SinkSender;

@RestController
@EnableBinding(value = {SinkSender.class, SinkOutputSender.class, GroupOutputBinder.class})
public class MessageProduceController {

    private SinkSender sinkSender;
    
    private SinkOutputSender sinkOutputSender;

    private GroupOutputBinder groupBinder;
	
	@Autowired
    public MessageProduceController(SinkSender sinkSender,SinkOutputSender sinkOutputSender, GroupOutputBinder groupBinder) {
		this.sinkSender = sinkSender;
		this.sinkOutputSender = sinkOutputSender;
		this.groupBinder = groupBinder;
	}
	
    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam String message) {
    	sinkSender.output().send(MessageBuilder.withPayload(message).build());
        return "ok";
    }
    
    @GetMapping("/sendOutputMessage")
    public String sendOutputMessage(@RequestParam String message) {
    	sinkOutputSender.output().send(MessageBuilder.withPayload(message).build());
    	return "ok";
    }
    
    @GetMapping("/sendGroupMessage")
    public String sendGroupMessage(@RequestParam String message) {
    	groupBinder.output().send(MessageBuilder.withPayload(message).build());
        return "ok";
    }
}

package com.wenqy.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wenqy.stream.binder.GroupOutputBinder;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=StreamDemoApplication.class)
@EnableBinding(value = {GroupOutputBinder.class})
public class StreamGroupDemoTester {

	@Autowired
	private GroupOutputBinder exampleBinder;

	@Test
	public void exampleBinderTester() {
        exampleBinder.output().send(MessageBuilder.withPayload("Produce a message from : I miss Y very much!!").build());
	}

}

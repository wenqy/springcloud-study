package com.wenqy.rocketmq.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;

import com.wenqy.rocketmq.binder.MySink;

/**
 * 拉取消息
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
public class ConsumerCustomRunner implements CommandLineRunner {

		@Autowired
		private MySink mySink;

		@Override
		public void run(String... args) throws InterruptedException {
			while (true) {
				mySink.input5().poll(m -> {
						String payload = (String) m.getPayload();
						System.out.println("pull msg: " + payload);
					}, new ParameterizedTypeReference<String>() {}
				);
				Thread.sleep(2_000);
			}
		}

	}
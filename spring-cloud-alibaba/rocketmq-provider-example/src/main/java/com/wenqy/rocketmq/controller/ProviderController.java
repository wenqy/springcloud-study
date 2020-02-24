package com.wenqy.rocketmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.rocketmq.bean.Foo;
import com.wenqy.rocketmq.binder.MySource;
import com.wenqy.rocketmq.service.ProviderService;
import com.wenqy.rocketmq.service.SenderService;

/**
 * 消息
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月17日
 */
@RestController
public class ProviderController {

	@Autowired
    private ProviderService providerService;
	
	@Autowired
	private SenderService senderService;
	
	@Autowired
	private MySource mySource;
	
	/**
	 * 发消息
	 * 	e.g. http://localhost:28081/sendMessage?message=hello
	 * @param message
	 * @return
	 * @author wenqy
	 * @date 2020年2月17日 下午6:01:14
	 */
	@GetMapping("/sendMessage")
    public String sendMessage(@RequestParam String message) {
		providerService.send(message);
        return "ok";
    }
	
	/**
	 * e.g. http://localhost:28081/sendMessageByBindingName?bindingName=output3
	 * @param bindingName
	 * @return
	 * @throws Exception
	 * @author wenqy
	 * @date 2020年2月17日 下午10:30:35
	 */
	@GetMapping("/sendMessageByBindingName")
	public String sendMessageByBindingName(@RequestParam String bindingName) throws Exception {
		if ("output1".equals(bindingName)) {
			int count = 5;
			for (int index = 1; index <= count; index++) {
				String msgContent = "msg-" + index;
				if (index % 3 == 0) {
					senderService.send(msgContent);
				}
				else if (index % 3 == 1) {
					senderService.sendWithTags(msgContent, "tagStr");
				}
				else {
					senderService.sendObject(new Foo(index, "foo"), "tagObj");
				}
			}
		}
		else if ("output3".equals(bindingName)) {
			int count = 20;
			for (int index = 1; index <= count; index++) {
				String msgContent = "pullMsg-" + index;
				mySource.output3()
						.send(MessageBuilder.withPayload(msgContent).build());
			}
		}
		return "ok";
	}
	
	/**
	 * 发送事务消息
	 * @return
	 * @throws Exception
	 * @author wenqy
	 * @date 2020年2月17日 下午10:27:13
	 */
	@GetMapping("/sendTransactionalMsg")
	public String sendTransactionalMsg() throws Exception {
		// COMMIT_MESSAGE message
		senderService.sendTransactionalMsg("transactional-msg1", 1);
		// ROLLBACK_MESSAGE message
		senderService.sendTransactionalMsg("transactional-msg2", 2);
		// COMMIT_MESSAGE message
		senderService.sendTransactionalMsg("transactional-msg3", 3);
		// COMMIT_MESSAGE message
		senderService.sendTransactionalMsg("transactional-msg4", 4);
		return "ok";
	}
}

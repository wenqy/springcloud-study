package com.wenqy.dubbo.consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.dubbo.api.EchoService;

@RestController
public class EchoController {

	// 禁用check，启动时不检查服务是否可用，否则，先启动消费者时，初始化报错:
	// 	Failed to check the status of the service ''. No provider available for the service
	// 先启动消费者，后启动提供方，报错：from registry localhost:9090 找不到提供者。。。
	// 消费依赖启动顺序这就不爽了吧。。
	// @see org.apache.dubbo.rpc.cluster.RouterChain.setInvokers(List<Invoker<T>>) invokers是空的
	// @see com.alibaba.cloud.dubbo.registry.AbstractSpringCloudRegistry.getExportedURLs(DubboMetadataService, URL)
	// 找到相关issues：https://github.com/alibaba/spring-cloud-alibaba/issues/695
	// 先启动消费者，后启动提供方， 2.1.0.RELEASE 升级 2.1.1.RELEASE 修复问题
	// 关闭消费者、提供方，再次先启动消费者，报错：
	// 	Connection refused: no further information: /10.188.190.87:20881 message can not send, because channel is closed 
	// nacos服务列表服务提供方还存在，没有及时下线，过一会再启动才可以， 定时健康检查有延迟，提供方的异常崩溃影响到消费者的重新上线，不稳定。。。
	// 先记录下，玩下去，脑壳都疼。。。
	@Reference(application="spring-cloud-alibaba-dubbo-server", check=false, lazy=true)
	private EchoService echoService;

	/**
	 * e.g. localhost:48082/echo?message=wenqy
	 * @param message
	 * @return
	 * @author wenqy
	 * @date 2020年3月16日 下午4:50:13
	 */
	@GetMapping("/echo")
	public String echo(String message) {
		return echoService.echo(message);
	}
}

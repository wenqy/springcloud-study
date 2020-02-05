package com.wenqy.consumer.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@RestController
public class RibbonHystrixDemoController {

	@Autowired
    ConsumerService consumerService;

	/**
	 * 
	 * e.g: http://localhost:8009/consumeHystrix?name=hystrix
	 * @param name
	 * @return
	 * @author wenqy
	 * @date 2020年1月8日 下午8:14:09
	 */
    @GetMapping("/consumeHystrix")
    public String consumeHystrix(@RequestParam(value = "name", defaultValue = "wenqy") String name) {
        return consumerService.consumer(name);
    }

    @Component
    class ConsumerService {

        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback") // 指定降级方法、依赖隔离（默认线程池隔离）
        public String consumer(String name) {
        	// 根据serverId负载到具体的服务实例
            return restTemplate.getForObject("http://provider-demo/hi?name="+name, String.class);
        }

        /**
         * 断路器：
         * 	快照时间窗：统计的时间范围，默认为最近的10秒
         * 	请求总数下限：在快照时间窗内，必须满足请求总数下限才有资格根据熔断，默认为20
         *  错误百分比下限：当请求总数在快照时间窗内超过了下限超过错误百分比，默认50%，断路器打开
         * 断路器打开，直接调用降级逻辑，此时为临时主逻辑，同时启动一个休眠时间窗
         * 	当休眠时间窗到期，断路器将进入半开状态，释放一次请求到原主逻辑上，
         * 		如果请求正常，那么断路器将继续闭合，主逻辑恢复，
         * 		如果请求依然有问题，断路器继续进入打开状态，休眠时间窗重新计时。
         * 降级方法与原方法参数一致
         * @return
         * @author wenqy
         * @date 2020年1月8日 下午6:25:44
         */
        public String fallback(String name) {
            return name + " fallback";
        }

    }
    
}

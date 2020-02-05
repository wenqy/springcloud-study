package com.wenqy.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.wenqy.apigateway.filter.AccessDemoFilter;

/**
 * API 网关
 * 	启动 eureka-provider、eureka-consumer
 * 		访问：http://localhost:8555/consumer-demo/consume
 * 			路由转发到http://localhost:8002/consumer-demo/consume
 * 	定义路由规则，维护path与serviceId映射关系，结合Ribbon负载均衡策略路由
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
@EnableZuulProxy // 开启zuul网关代理
@SpringCloudApplication
public class ZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}
	
	/**
	 * 定义过滤器后拦截后，放行有accessToken参数的请求,否则返回401
	 * 		http://localhost:8555/consumer-demo/consume?accessToken=token
	 * @return
	 * @author wenqy
	 * @date 2020年1月9日 下午4:43:10
	 */
	@Bean
	public AccessDemoFilter accessFilter() {
		return new AccessDemoFilter();
	}
}

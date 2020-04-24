package com.wenqy.oauth2.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
import org.springframework.context.annotation.Bean;

/**
 * 启动nacos-server\nacos-discovery-consumer-example\nacos-discovery-provider-example
 * e.g. http://localhost:58094/consumer/echo-rest/wenqy
 * 
 * 启动spring-security-oauth2-server-jwt-asym\spring-security-oauth2-resource-jwt-asym
 * e.g. http://localhost:58094/oauth2-resource/users
 * 
 * Spring-Cloud-Gateway采用Webflux与SpringMVC冲突，移除spring-boot-starter-web依赖
 * @version V5.0
 * @author wenqy
 * @date   2020年4月9日
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OAuthGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthGatewayApplication.class, args);
	}
	
	@Autowired
	private TokenRelayGatewayFilterFactory filterFactory;

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("oauth2-resource", r -> r.path("/oauth2-resource/**")
						.filters(f -> f.filter(filterFactory.apply()))
						.uri("http://localhost:58092/oauth2-resource"))
				.build();
	}
}

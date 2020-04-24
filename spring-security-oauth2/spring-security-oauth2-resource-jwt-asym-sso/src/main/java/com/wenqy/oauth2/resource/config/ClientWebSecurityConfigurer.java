//package com.wenqy.oauth2.resource.config;
//
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * WebSecurity
// * 		ResourceConfig的OAuth2AuthenticationProcessingFilter
// * 		先于Sso的OAuth2ClientAuthenticationProcessingFilter
// * 		不要在资源服务器启用Sso，不会跳转
// * @version V5.0
// * @author wenqy
// * @date   2020年3月29日
// */
//@Configuration
////@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
////@Order(101)
//@EnableOAuth2Sso
//public class ClientWebSecurityConfigurer extends WebSecurityConfigurerAdapter {
//
////	@Override
////    public void configure(HttpSecurity http) throws Exception {
////        http.antMatcher("/**").authorizeRequests()
////                .anyRequest().authenticated();
////    }
//}

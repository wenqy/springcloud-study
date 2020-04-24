package com.wenqy.oauth2.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Web Security
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年3月28日
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, // 全局方法拦截
	securedEnabled = true, 
	jsr250Enabled = true
	)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	/**
	 * 
	 * Spring Security 5.0 之前版本的 PasswordEncoder 接口默认实现为 NoOpPasswordEncoder，此时是可以使用明文密码的。
	 * 	在 5.0 之后默认实现类改为 DelegatingPasswordEncoder 此时密码必须以加密形式存储。
	 * 否则，申请令牌时报错：
	 * 	java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
	 * 
	 * @author wenqy
	 * @date 2020年3月27日 上午10:26:41
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// 设置默认的加密方式
        return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		// 在内存中创建用户并为密码加密
        .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");
	}

	/**
	 * 认证服务需放行：/oauth/check_token 请求
	 * 否则资源服务端会报403：
	 * 	org.springframework.web.client.HttpClientErrorException$Forbidden: 403 : [{"timestamp":"2020-03-27T08:07:42.904+0000","status":403,"error":"Forbidden","message":"Forbidden","path":"/oauth/check_token"}]
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
	 * @param web
	 * @throws Exception
	 * @author wenqy
	 * @date 2020年3月27日 下午4:09:33
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/oauth/check_token");
	}
}

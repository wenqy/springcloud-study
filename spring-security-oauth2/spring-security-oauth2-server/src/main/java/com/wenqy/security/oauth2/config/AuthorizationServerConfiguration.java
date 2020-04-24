package com.wenqy.security.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 认证服务配置
 * 
 * 默认的端点 URL
 * /oauth/authorize：授权端点
 * /oauth/token：令牌端点
 * /oauth/confirm_access：用户确认授权提交端点
 * /oauth/error：授权服务错误信息端点
 * /oauth/check_token：用于资源服务访问的令牌解析端点
 * /oauth/token_key：提供公有密匙的端点，如果你使用 JWT 令牌的话
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年3月27日
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	// 注入 WebSecurityConfiguration 中配置的 BCryptPasswordEncoder
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
	/**
	 * e.g. 
	 *  1、访问授权请求
	 *  http://localhost:58080/oauth/authorize?client_id=client&response_type=code
	 * 	2、跳转登录，输入账号密码，登录后，询问授权，确认后重定向回调地址，返回授权码
	 *  	http://localhost:58080/?code=QIb0rM
	 *  3、通过授权码向服务器申请令牌
	 *  	curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=authorization_code&code=4UXC7Q' "http://client:secret@localhost:58080/oauth/token"
	 *  	返回access_token
	 *  	{
			    "access_token": "d38a778c-10aa-44fa-be94-312d4e47270c",
			    "token_type": "bearer",
			    "expires_in": 43199,
			    "scope": "app"
			}
		4、授权码只能用一次：
			{
			    "error": "invalid_grant",
			    "error_description": "Invalid authorization code: Y8FxMJ"
			}
			
			
			
	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
	 * @param clients
	 * @throws Exception
	 * @author wenqy
	 * @date 2020年3月27日 上午9:58:04
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// 内存存储令牌
		// 配置客户端
        clients
                // 使用内存设置
                .inMemory()
                // client_id
                .withClient("client")
                // client_secret
//                .secret("secret")
                // 还需要为 secret 加密, 否则无法申请到令牌：Encoded password does not look like BCrypt
                .secret(passwordEncoder.encode("secret"))
                // 授权类型
                .authorizedGrantTypes("authorization_code")
                // 授权范围
                .scopes("app")
                // 注册回调地址
                .redirectUris("http://localhost:58080");
	}

	
}

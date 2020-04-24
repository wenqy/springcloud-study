package com.wenqy.oauth2.server.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * 认证服务配置-JDBC
 *  1、数据源配置
 *  	初始化 oAuth2 相关表
 *  		https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql
 *  		由于我们使用的是 MySQL 数据库，默认建表语句中主键为 VARCHAR(256)，这超过了最大的主键长度，请手动修改为 128；
 *  		并用 BLOB 替换语句中的 LONGVARBINARY 类型。
 *  		可使用本地整理SQL：sql/schema.sql
 *  		初始化插入一条客户端配置记录
 *  
 *  e.g. 
 *  访问授权请求
 *  http://localhost:58081/oauth/authorize?client_id=client&response_type=code
 * 	跳转登录，输入账号密码，登录后，询问授权，确认后重定向回调地址，返回授权码
 *  	http://localhost:58081/?code=afGwq8
 *  通过授权码向服务器申请令牌
 *  	curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=authorization_code&code=afGwq8' "http://client:secret@localhost:58081/oauth/token"
 *  	返回access_token
 *  	{
		    "access_token": "8f1278c1-b6b0-4bbf-830f-f56fae2f693e",
		    "token_type": "bearer",
		    "expires_in": 43199,
		    "scope": "app"
		}
	授权码只能用一次：
		{
		    "error": "invalid_grant",
		    "error_description": "Invalid authorization code: afGwq8"
		}
 * @version V5.0
 * @author wenqy
 * @date   2020年3月27日
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	
	@Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        // 配置数据源（注意，使用的是 HikariCP 连接池），以上注解是指定数据源，否则会有冲突
        return DataSourceBuilder.create().build();
    }

    @Bean
    public TokenStore tokenStore() {
        // 基于 JDBC 实现，令牌保存到数据
        return new JdbcTokenStore(dataSource());
    }

    @Bean
    public ClientDetailsService jdbcClientDetails() {
        // 基于 JDBC 实现，需要事先在数据库配置客户端信息
        return new JdbcClientDetailsService(dataSource());
    }

    // 配置服务端点信息
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 设置令牌
        endpoints.tokenStore(tokenStore());
    }
    
    // 配置客户端信息
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 读取客户端配置
        clients.withClientDetails(jdbcClientDetails());
    }

}

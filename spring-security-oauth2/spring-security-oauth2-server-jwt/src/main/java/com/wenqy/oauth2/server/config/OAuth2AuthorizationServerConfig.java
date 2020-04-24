package com.wenqy.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    
	@Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	@Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) 
      throws Exception {
        endpoints.tokenStore(tokenStore())
                 .accessTokenConverter(accessTokenConverter())
                 .authenticationManager(authenticationManager);
    }
 
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
 
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123"); // 对称密钥
        return converter;
    }
 
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }
    
    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    	// 允许访问/oauth/token申请token 如果不允许表单认证,出现401错误
        oauthServer.allowFormAuthenticationForClients();
    }

    /**
     * e.g.
     * 	http://localhost:58083/oauth/authorize?client_id=barClientIdPassword&response_type=code&redirect_uri=http://www.example.com
     *  拿到授权码wmmlps后：
     *  curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=authorization_code&code=wmmlps&client_id=barClientIdPassword&client_secret=secret' "http://client:secret@localhost:58083/oauth/token"
     *  返回：
     *  {
     *		"access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODU0MDAzNzAsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiIwN2U0ZjI0Ni00ZTc2LTQ5MGItODY2YS0zZmVhNDMxYjIxYzUiLCJjbGllbnRfaWQiOiJiYXJDbGllbnRJZFBhc3N3b3JkIiwic2NvcGUiOlsiYmFyIiwicmVhZCIsIndyaXRlIl19.ItoeNHgbPnsjbhCEEJsaoRI5yonL-xsh3F-Xg2X64-o",
     *		"token_type": "bearer",
     *		"expires_in": 3576,
     * 		"scope": "bar read write",
     *      "jti": "07e4f246-4e76-490b-866a-3fea431b21c5"
	 *	}
	 *
     * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
     * @param clients
     * @throws Exception
     * @author wenqy
     * @date 2020年3月28日 下午7:03:06
     */
    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception { // @formatter:off
        clients.inMemory()
                .withClient("sampleClientId")
                .authorizedGrantTypes("implicit")
                .scopes("read", "write", "foo", "bar")
                .autoApprove(false)
                .accessTokenValiditySeconds(3600)
                .redirectUris("http://localhost:8083/","http://localhost:8086/")
                .and()
                .withClient("fooClientIdPassword")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials")
                .scopes("foo", "read", "write")
                .accessTokenValiditySeconds(3600)       // 1 hour
                .refreshTokenValiditySeconds(2592000)  // 30 days
                .redirectUris("http://www.example.com","http://localhost:8089/","http://localhost:8080/login/oauth2/code/custom","http://localhost:8080/ui-thymeleaf/login/oauth2/code/custom", "http://localhost:8080/authorize/oauth2/code/bael", "http://localhost:8080/login/oauth2/code/bael")
                .and()
                .withClient("barClientIdPassword")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .scopes("bar", "read", "write")
                .accessTokenValiditySeconds(3600)       // 1 hour
                .refreshTokenValiditySeconds(2592000)  // 30 days
                .redirectUris("http://www.example.com")
                .and()
                .withClient("testImplicitClientId")
                .authorizedGrantTypes("implicit")
                .scopes("read", "write", "foo", "bar")
                .autoApprove(true)
                .redirectUris("http://www.example.com");
    } // @formatter:on
}
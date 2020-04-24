package com.wenqy.oauth2.resource.filter;

import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;

public class CustomOAuth2ClientAuthenticationProcessingFilter extends OAuth2ClientAuthenticationProcessingFilter {

	public CustomOAuth2ClientAuthenticationProcessingFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
	}

}

package com.wenqy.config.client.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 配置中心 配置映射对象
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@Data
@Component
public class GitConfigBean {
	
    @Value("${info.profile}")
    private String profile;
    
    @Value("${info.from}")
    private String from;

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
    
}

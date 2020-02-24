package com.wenqy.config.configbean;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User配置类 配置中心实时加载
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月20日
 */
@ConfigurationProperties(prefix = "user")
public class UserConfig {

	private int age;

	private String name;

	private Map<String, Object> map;

	private String sex;
	
	private String country;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "UserConfig [age=" + age + ", name=" + name + ", map=" + map + ", sex=" + sex + ", country=" + country
				+ "]";
	}

	

}
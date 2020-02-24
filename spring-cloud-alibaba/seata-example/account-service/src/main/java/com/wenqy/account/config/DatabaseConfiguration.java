package com.wenqy.account.config;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class DatabaseConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSource storageDataSource() {
		return new DruidDataSource();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// 初始化account测试数据
		jdbcTemplate.update("delete from account_tbl where user_id = 'U100001'");
		jdbcTemplate.update(
				"insert into account_tbl(user_id, money) values ('U100001', 10000)");

		return jdbcTemplate;
	}

}

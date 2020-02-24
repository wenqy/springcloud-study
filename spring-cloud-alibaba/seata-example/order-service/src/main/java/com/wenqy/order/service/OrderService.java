package com.wenqy.order.service;

import java.sql.PreparedStatement;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.wenqy.order.entity.Order;

@Service
public class OrderService {

//	private static final String USER_ID = "U100001";
	
	private Random random = new Random();
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 下单
	 * @param order
	 * @return
	 * @author wenqy
	 * @date 2020年2月21日 下午11:00:46
	 */
	@Transactional
	public int order(Order order) {

		deductAccount(order.getMoney(), order.getUserId()); // 扣减余额
		
		int result = insertOrder(order); // 保存订单
		
		if (random.nextBoolean()) { // 随机模拟异常
			throw new RuntimeException("Order 模拟异常抛错！！");
		}
		return result;
	}

	/**
	 * 插入订单
	 * @param order
	 * @return
	 * @author wenqy
	 * @date 2020年2月19日 上午11:32:01
	 */
	private int insertOrder(Order order) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int result = jdbcTemplate.update(con-> {
			PreparedStatement pst = con.prepareStatement(
					"insert into order_tbl (user_id, commodity_code, count, money) values (?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setObject(1, order.getUserId());
			pst.setObject(2, order.getCommodityCode());
			pst.setObject(3, order.getCount());
			pst.setObject(4, order.getMoney());
			return pst;
		}, keyHolder);
		order.setId(keyHolder.getKey().longValue());
		return result;
	}
	
	/**
	 * 扣减账户余额
	 * @param orderMoney
	 * @param userId
	 * @author wenqy
	 * @date 2020年2月19日 上午11:21:24
	 */
	private void deductAccount(int orderMoney, String userId) {
		String url = "http://account-service/account";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

		map.add("userId", userId);
		map.add("money", orderMoney + "");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(
				map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(url, request,
				String.class);
	}
}

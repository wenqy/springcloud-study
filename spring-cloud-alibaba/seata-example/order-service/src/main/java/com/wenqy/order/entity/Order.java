package com.wenqy.order.entity;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = -2218856140736912158L;

	/**
	 * id.
	 */
	private long id;

	/**
	 * user id.
	 */
	private String userId;

	/**
	 * commodity code.
	 */
	private String commodityCode;

	/**
	 * count.
	 */
	private int count;

	/**
	 * money.
	 */
	private int money;

	@Override
	public String toString() {
		return "Order{" + "id=" + id + ", userId='" + userId + '\'' + ", commodityCode='"
				+ commodityCode + '\'' + ", count=" + count + ", money=" + money + '}';
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
}

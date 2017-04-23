package com.athensoft.ecomm.order.dao;

import java.util.List;

import com.athensoft.ecomm.order.entity.Order;

public interface OrderDao {
	public List<Order> findAll();
	public Order findById(long orderId);
	public Order findByNo(String orderNo);
}

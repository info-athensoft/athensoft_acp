package com.athensoft.ecomm.order.dao;

import java.util.List;

import com.athensoft.ecomm.order.entity.Order;
import com.athensoft.ecomm.order.entity.OrderItem;

public interface OrderItemDao {
	public List<OrderItem> findByOrderNo(String orderNo);
	public List<OrderItem> findByOrderNo(Order order);
	
	public List<OrderItem> findByOrderId(long orderId);
	public List<OrderItem> findByOrderId(Order order);
}

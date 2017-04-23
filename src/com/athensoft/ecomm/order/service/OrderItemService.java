package com.athensoft.ecomm.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.athensoft.ecomm.order.dao.OrderItemDao;
import com.athensoft.ecomm.order.entity.OrderItem;

/**
 * @author Athens
 *
 */
@Service
public class OrderItemService {
	private OrderItemDao orderItemDao;
	
	@Autowired
	@Qualifier("orderItemDaoJDBCImpl")
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}
	
	public List<OrderItem> getOrderItemsByOrderNo(String orderNo){
		return orderItemDao.findByOrderNo(orderNo);
	}
}

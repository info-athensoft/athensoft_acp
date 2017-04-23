package com.athensoft.ecomm.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.athensoft.ecomm.order.dao.OrderDao;
import com.athensoft.ecomm.order.dao.OrderItemDao;
import com.athensoft.ecomm.order.entity.Order;
import com.athensoft.ecomm.order.entity.OrderItem;

/**
 * @author Athens
 *
 */
@Service
public class OrderService {
	private OrderDao orderDao;
	
	private OrderItemDao orderItemDao;
	
	@Autowired
	@Qualifier("orderDaoJDBCImpl")
	public void setOrderao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	@Autowired
	@Qualifier("orderItemDaoJDBCImpl")
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}
	
	/**
	 * @param orderId
	 * @return
	 */
	public Order getOrderByOrderId(long orderId){
		Order order = new Order();
		order = orderDao.findById(orderId);
		
		System.out.println("orderId="+orderId);
		
//		order.setOrderItems(orderItemDao.findByOrderNo(orderId));
		return order;
	}
	
	/**
	 * @param orderId
	 * @return
	 */
	public Order getOrderByOrderNo(String orderNo){
		System.out.println("getOrderByOrderNo()");
		Order order = new Order();
		order = orderDao.findByNo(orderNo);
		
		System.out.println("orderNo="+orderNo);
		System.out.println("orderItemDao="+orderItemDao);
		
		List<OrderItem> list = orderItemDao.findByOrderNo(orderNo);
		System.out.println("OrderItem size="+list.size());
		
		System.out.print("order.getOrderItems()="+order.getOrderItems());
		order.setOrderItems(list);
		return order;
	}
	
	/**
	 * @return
	 */
	public List<Order> getAllOrders(){
		List<Order> orders = orderDao.findAll();
		return orders;
	}
	
	
}
